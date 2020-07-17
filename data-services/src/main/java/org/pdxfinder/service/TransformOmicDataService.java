package org.pdxfinder.service;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.TumorTypeConstants;
import org.pdxfinder.domain.OncokbGenePanel;
import org.pdxfinder.domain.Sample;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.tsv.OmicTsv;
import org.pdxfinder.util.FileUtil;
import org.pdxfinder.util.OmicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class TransformOmicDataService {

    private final Logger log = LoggerFactory.getLogger(TransformOmicDataService.class);

    public List<OmicTsv> transformOmicData(ExtractDto extracted) {
        log.info("Start Transforming Omic data-sets");

        List<OncokbGenePanel> oncokbGenePanels = extracted.getOncokbGenePanels();
        List<Sample> samples = extracted.getSamples();

        List<OmicTsv> transformedData = new ArrayList<>();
        for (OncokbGenePanel oncoKb : oncokbGenePanels) {
            AtomicBoolean validData = new AtomicBoolean(false);
            OmicTsv omicDataRow = OmicUtil.get(oncoKb, extracted)
                    .setReadDepth(oncoKb.getTotalreads())
                    .setAlleleFrequency(oncoKb.getVariantadellefreq())
                    .setSeqStartPosition(oncoKb.getStartposition())
                    .setRefAllele(oncoKb.getReferenceallele())
                    .setAltAllele(oncoKb.getAltallele())
                    .setUcscGeneId(DataConstants.EMPTY)
                    .setNcbiGeneId(DataConstants.EMPTY)
                    .setEnsemblGeneId(DataConstants.EMPTY)
                    .setEnsemblTranscriptId(DataConstants.EMPTY)
                    .setGenomeAssembly(DataConstants.HG19_GENOME)
                    .setPlatform(DataConstants.PDMR_PLATFORM);

            samples.forEach(sample -> {

                if (oncoKb.getSampleseqnbr().equals(sample.getSampleseqnbr())) {
                    String modelId = OmicUtil.getModelId(sample, extracted);
                    String samplePassage = sample.getPassageofthissample();
                    omicDataRow.setModelId(modelId)
                            .setDataSource(DataConstants.PDMR_ABBREV)
                            .setSampleId(sample.getSampleid())
                            .setHostStrainName(DataConstants.NSG_HOST_STRAIN_FULL);

                    if (FileUtil.isNumeric(samplePassage)) {
                        omicDataRow.setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR);
                        omicDataRow.setPassage(samplePassage);
                        validData.set(true);
                    } else if (sample.getSampleid().equals(DataConstants.PDMR_PATIENT_SAMPLE_ID)) {
                        omicDataRow.setSampleOrigin(TumorTypeConstants.PATIENT_TUMOR);
                        omicDataRow.setPassage(DataConstants.EMPTY);
                        validData.set(true);
                    } else {
                        validData.set(false);
                    }
                }
            });

            if (validData.get()) {
                transformedData.add(omicDataRow);
            }
        }

        log.info("Finished Transforming Omic data-sets");
        return transformedData;

    }
}

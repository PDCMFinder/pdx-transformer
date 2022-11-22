package org.pdxfinder.services.pdmr.extractor;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.data.model.OncokbGenePanel;
import org.pdxfinder.data.model.Sample;
import org.pdxfinder.data.model.SpecimenSearch;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.pdxfinder.services.result.dto.MutationTsv;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ExtractOmic {

    private ExtractOmic() {
        // Never called
    }

    public static MutationTsv main(OncokbGenePanel oncoKb, OracleDataDto extracted) {

        return new MutationTsv()
                .setHgncSymbol(getHugoGeneSymbol(oncoKb, extracted))
                .setCodingSequenceChange(getCodingSequenceChange(oncoKb))
                .setAminoAcidChange(getAminoAcidChange(oncoKb))
                .setConsequence(getConsequence(oncoKb, extracted))
                .setFunctionalPrediction(getFunctionalPrediction(oncoKb))
                .setChromosome(getChromosome(oncoKb))
                .setVariationId(getVariantId(oncoKb));
    }


    public static String getConsequence(OncokbGenePanel oncoKb, OracleDataDto extracted){
        AtomicReference<String> consequence = new AtomicReference<>(DataConstants.EMPTY);
        extracted.getVariantClasses().forEach(variantClass -> {
            if ( String.valueOf(oncoKb.getVariantclassseqnbr()).equals(String.valueOf(variantClass.getVariantclassseqnbr())) ){
                consequence.set(variantClass.getVariantclassdescription());
            }
        });
        return consequence.get();
    }


    public static String getHugoGeneSymbol(OncokbGenePanel oncoKb, OracleDataDto extracted) {
        AtomicReference<String> symbol = new AtomicReference<>(DataConstants.EMPTY);
        extracted.getHugoGeneSymbols().forEach(hgncSymbol -> {
            if (oncoKb.getHugogenesymbolseqnbr().equals(hgncSymbol.getHugogenesymbolseqnbr())) {
                symbol.set(hgncSymbol.getHugogenesymboldescription());
            }
        });
        return symbol.get();
    }

    public static String getCodingSequenceChange(OncokbGenePanel oncoKb) {
        Optional<String> codingSequenceChange = Optional.ofNullable(oncoKb.getHgvscdnachange());
        return codingSequenceChange.map(s -> s.replace("c.", DataConstants.EMPTY)).orElse(DataConstants.EMPTY);
    }

    public static String getAminoAcidChange(OncokbGenePanel oncokbGenePanel) {
        Optional<String> aminoAcidChange = Optional.ofNullable(oncokbGenePanel.getHgvsproteinchange());
        return aminoAcidChange.map(s -> s.replace("p.", DataConstants.EMPTY)).orElse(DataConstants.EMPTY);
    }

    public static String getFunctionalPrediction(OncokbGenePanel oncoKb) {
        Optional<String> functionalPrediction = Optional.ofNullable(oncoKb.getPolyphen());
        return functionalPrediction.isPresent() ? String.format("%s|sift", functionalPrediction.get()) : DataConstants.EMPTY;
    }

    public static String getVariantId(OncokbGenePanel oncoKb) {
        Optional<String> variantId = Optional.ofNullable(oncoKb.getExistingvariant());
        return variantId.orElse(DataConstants.EMPTY);
    }

    public static String getChromosome(OncokbGenePanel oncoKb) {
        Optional<String> chromosome = Optional.ofNullable(oncoKb.getChromosome());
        return chromosome.map(s -> s.replace("chr", DataConstants.EMPTY)).orElse(DataConstants.EMPTY);
    }

    // Search for the specimenSeqNumber inside the sampleSearch Data
    public static String getModelId(Sample sample, OracleDataDto extracted){
        List<SpecimenSearch> specimenSearches = extracted.getSpecimenSearchList();
        AtomicReference<String> modelId = new AtomicReference<>(DataConstants.EMPTY);
        AtomicReference<String> sampleId = new AtomicReference<>("");
        specimenSearches.forEach(specimen -> {
            if (specimen.getSpecimenseqnbr().equals(sample.getSpecimenseqnbr())) {
                if(specimen.getPdmtypeseqnbr().equals("6")){
                    for (Sample dSample : extracted.getSamples()) {
                        if (specimen.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                            if(dSample.getPdmtypeseqnbr().equals("6")) {
                                sampleId.set(dSample.getSampleid());
                            }
                        }
                    }
                    modelId.set(String.format(specimen.getPatientid() + "-" + specimen.getSpecimenid()+ "-" + sampleId.get()));
                }else {
                    modelId.set(specimen.getPatientid() + "-" + specimen.getSpecimenid());
                }
            }
        });
        return modelId.get();
    }

}

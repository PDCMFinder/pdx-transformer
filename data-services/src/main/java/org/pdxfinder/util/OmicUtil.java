package org.pdxfinder.util;

import org.pdxfinder.domain.OncokbGenePanel;
import org.pdxfinder.domain.Sample;
import org.pdxfinder.domain.SpecimenSearch;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.tsv.OmicTsv;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class OmicUtil {

    private OmicUtil() {
        // Never called
    }

    public static OmicTsv get(OncokbGenePanel oncoKb, ExtractDto extracted) {

        return new OmicTsv()
                .setHgncSymbol(OmicUtil.getHugoGeneSymbol(oncoKb, extracted))
                .setCodingSequenceChange(OmicUtil.getCodingSequenceChange(oncoKb))
                .setAminoAcidChange(OmicUtil.getAminoAcidChange(oncoKb))
                .setConsequence(OmicUtil.getConsequence(oncoKb, extracted))
                .setConsequence(OmicUtil.getFunctionalPrediction(oncoKb))
                .setChromosome(OmicUtil.getChromosome(oncoKb))
                .setVariationId(OmicUtil.getVariantId(oncoKb));
    }


    public static String getConsequence(OncokbGenePanel oncoKb, ExtractDto extracted){
        AtomicReference<String> consequence = new AtomicReference<>("");
        extracted.getVariantClasses().forEach(variantClass -> {
            if ( String.valueOf(oncoKb.getVariantclassseqnbr()).equals(String.valueOf(variantClass.getVariantclassseqnbr())) ){
                consequence.set(variantClass.getVariantclassdescription());
            }
        });
        return consequence.get();
    }


    public static String getHugoGeneSymbol(OncokbGenePanel oncoKb, ExtractDto extracted) {
        AtomicReference<String> symbol = new AtomicReference<>("");
        extracted.getHugoGeneSymbols().forEach(hgncSymbol -> {
            if (oncoKb.getHugogenesymbolseqnbr().equals(hgncSymbol.getHugogenesymbolseqnbr())) {
                symbol.set(hgncSymbol.getHugogenesymboldescription());
            }
        });
        return symbol.get();
    }

    public static String getCodingSequenceChange(OncokbGenePanel oncoKb) {
        Optional<String> codingSequenceChange = Optional.ofNullable(oncoKb.getHgvscdnachange());
        return codingSequenceChange.map(s -> s.replace("c.", "")).orElse("");
    }

    public static String getAminoAcidChange(OncokbGenePanel oncokbGenePanel) {
        Optional<String> aminoAcidChange = Optional.ofNullable(oncokbGenePanel.getHgvsproteinchange());
        return aminoAcidChange.map(s -> s.replace("p.", "")).orElse("");
    }

    public static String getFunctionalPrediction(OncokbGenePanel oncoKb) {
        Optional<String> functionalPrediction = Optional.ofNullable(oncoKb.getPolyphen());
        return functionalPrediction.isPresent() ? String.format("%s|sift", functionalPrediction.get()) : "";
    }

    public static String getVariantId(OncokbGenePanel oncoKb) {
        Optional<String> variantId = Optional.ofNullable(oncoKb.getExistingvariant());
        return variantId.orElse("");
    }

    public static String getChromosome(OncokbGenePanel oncoKb) {
        Optional<String> chromosome = Optional.ofNullable(oncoKb.getChromosome());
        return chromosome.map(s -> s.replace("chr", "")).orElse("");
    }

    // Search for the specimenSeqNumber inside the sampleSearch Data
    public static String getModelId(Sample sample, ExtractDto extracted){
        List<SpecimenSearch> specimenSearches = extracted.getSpecimenSearchList();
        AtomicReference<String> modelId = new AtomicReference<>("");
        specimenSearches.forEach(specimen -> {
            if (specimen.getSpecimenseqnbr().equals(sample.getSpecimenseqnbr())) {
                modelId.set(specimen.getPatientid() + "-" + specimen.getSpecimenid());
            }
        });
        return modelId.get();
    }

}

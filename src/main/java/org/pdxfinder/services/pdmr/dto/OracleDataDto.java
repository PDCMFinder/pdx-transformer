package org.pdxfinder.services.pdmr.dto;

import org.pdxfinder.data.model.*;
import org.pdxfinder.data.model.projection.HistologyProjection;

import java.util.List;

public class OracleDataDto {
    
    private List<PatientInfo> patientList;
    private List<Sample> samples;
    private List<HistologyProjection> histologies;
    private List<TumorGrades> tumorGradesList;
    private List<CurrentTherapy> currentTherapies;
    private List<StandardizedRegimens> standardRegimens;
    private List<ClinicalResponses> clinicalResponses;
    private List<PriorTherapies> priorTherapiesList;
    private List<TumorGradeStageTypes> tumorGradeStageTypes;
    private List<TissueTypes> tissueTypes;
    private List<MouseStrains> mouseStrains;
    private List<ImplantationSites> implantationSites;
    private List<ProvidedTissueOrigins> tissueOrigins;
    private List<Specimen> specimenList;
    private List<SpecimenSearch> specimenSearchList;
    private List<OncokbGenePanel> oncokbGenePanels;
    private List<HugoGeneSymbol> hugoGeneSymbols;
    private List<VariantClass> variantClasses;


    public List<PatientInfo> getPatientList() {
        return patientList;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public List<HistologyProjection> getHistologies() {
        return histologies;
    }

    public List<TumorGrades> getTumorGradesList() {
        return tumorGradesList;
    }

    public List<CurrentTherapy> getCurrentTherapies() {
        return currentTherapies;
    }

    public List<StandardizedRegimens> getStandardRegimens() {
        return standardRegimens;
    }

    public List<ClinicalResponses> getClinicalResponses() {
        return clinicalResponses;
    }

    public List<PriorTherapies> getPriorTherapiesList() {
        return priorTherapiesList;
    }

    public List<TumorGradeStageTypes> getTumorGradeStageTypes() {
        return tumorGradeStageTypes;
    }

    public List<TissueTypes> getTissueTypes() {
        return tissueTypes;
    }

    public List<MouseStrains> getMouseStrains() {
        return mouseStrains;
    }

    public List<ImplantationSites> getImplantationSites() {
        return implantationSites;
    }

    public List<ProvidedTissueOrigins> getTissueOrigins() {
        return tissueOrigins;
    }

    public List<Specimen> getSpecimenList() {
        return specimenList;
    }

    public List<SpecimenSearch> getSpecimenSearchList() {
        return specimenSearchList;
    }

    public List<OncokbGenePanel> getOncokbGenePanels() {
        return oncokbGenePanels;
    }

    public List<HugoGeneSymbol> getHugoGeneSymbols() {
        return hugoGeneSymbols;
    }

    public List<VariantClass> getVariantClasses() {
        return variantClasses;
    }

    public OracleDataDto setPatientList(List<PatientInfo> patientList) {
        this.patientList = patientList;
        return this;
    }

    public OracleDataDto setSamples(List<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public OracleDataDto setHistologies(List<HistologyProjection> histologies) {
        this.histologies = histologies;
        return this;
    }

    public OracleDataDto setTumorGradesList(List<TumorGrades> tumorGradesList) {
        this.tumorGradesList = tumorGradesList;
        return this;
    }

    public OracleDataDto setCurrentTherapies(List<CurrentTherapy> currentTherapies) {
        this.currentTherapies = currentTherapies;
        return this;
    }

    public OracleDataDto setStandardRegimens(List<StandardizedRegimens> standardRegimens) {
        this.standardRegimens = standardRegimens;
        return this;
    }

    public OracleDataDto setClinicalResponses(List<ClinicalResponses> clinicalResponses) {
        this.clinicalResponses = clinicalResponses;
        return this;
    }

    public OracleDataDto setPriorTherapiesList(List<PriorTherapies> priorTherapiesList) {
        this.priorTherapiesList = priorTherapiesList;
        return this;
    }

    public OracleDataDto setTumorGradeStageTypes(List<TumorGradeStageTypes> tumorGradeStageTypes) {
        this.tumorGradeStageTypes = tumorGradeStageTypes;
        return this;
    }

    public OracleDataDto setTissueTypes(List<TissueTypes> tissueTypes) {
        this.tissueTypes = tissueTypes;
        return this;
    }

    public OracleDataDto setMouseStrains(List<MouseStrains> mouseStrains) {
        this.mouseStrains = mouseStrains;
        return this;
    }

    public OracleDataDto setImplantationSites(List<ImplantationSites> implantationSites) {
        this.implantationSites = implantationSites;
        return this;
    }

    public OracleDataDto setTissueOrigins(List<ProvidedTissueOrigins> tissueOrigins) {
        this.tissueOrigins = tissueOrigins;
        return this;
    }

    public OracleDataDto setSpecimenList(List<Specimen> specimenList) {
        this.specimenList = specimenList;
        return this;
    }

    public OracleDataDto setSpecimenSearchList(List<SpecimenSearch> specimenSearchList) {
        this.specimenSearchList = specimenSearchList;
        return this;
    }

    public OracleDataDto setOncokbGenePanels(List<OncokbGenePanel> oncokbGenePanels) {
        this.oncokbGenePanels = oncokbGenePanels;
        return this;
    }

    public OracleDataDto setHugoGeneSymbols(List<HugoGeneSymbol> hugoGeneSymbols) {
        this.hugoGeneSymbols = hugoGeneSymbols;
        return this;
    }

    public OracleDataDto setVariantClasses(List<VariantClass> variantClasses) {
        this.variantClasses = variantClasses;
        return this;
    }

    public OracleDataDto build() {
        return this;
    }


}

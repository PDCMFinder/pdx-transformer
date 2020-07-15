package org.pdxfinder.dto;

import org.pdxfinder.domain.*;
import org.pdxfinder.domain.projection.*;

import java.util.List;

public class ExtractDto {
    
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

    public ExtractDto setPatientList(List<PatientInfo> patientList) {
        this.patientList = patientList;
        return this;
    }

    public ExtractDto setSamples(List<Sample> samples) {
        this.samples = samples;
        return this;
    }

    public ExtractDto setHistologies(List<HistologyProjection> histologies) {
        this.histologies = histologies;
        return this;
    }

    public ExtractDto setTumorGradesList(List<TumorGrades> tumorGradesList) {
        this.tumorGradesList = tumorGradesList;
        return this;
    }

    public ExtractDto setCurrentTherapies(List<CurrentTherapy> currentTherapies) {
        this.currentTherapies = currentTherapies;
        return this;
    }

    public ExtractDto setStandardRegimens(List<StandardizedRegimens> standardRegimens) {
        this.standardRegimens = standardRegimens;
        return this;
    }

    public ExtractDto setClinicalResponses(List<ClinicalResponses> clinicalResponses) {
        this.clinicalResponses = clinicalResponses;
        return this;
    }

    public ExtractDto setPriorTherapiesList(List<PriorTherapies> priorTherapiesList) {
        this.priorTherapiesList = priorTherapiesList;
        return this;
    }

    public ExtractDto setTumorGradeStageTypes(List<TumorGradeStageTypes> tumorGradeStageTypes) {
        this.tumorGradeStageTypes = tumorGradeStageTypes;
        return this;
    }

    public ExtractDto setTissueTypes(List<TissueTypes> tissueTypes) {
        this.tissueTypes = tissueTypes;
        return this;
    }

    public ExtractDto setMouseStrains(List<MouseStrains> mouseStrains) {
        this.mouseStrains = mouseStrains;
        return this;
    }

    public ExtractDto setImplantationSites(List<ImplantationSites> implantationSites) {
        this.implantationSites = implantationSites;
        return this;
    }

    public ExtractDto setTissueOrigins(List<ProvidedTissueOrigins> tissueOrigins) {
        this.tissueOrigins = tissueOrigins;
        return this;
    }

    public ExtractDto setSpecimenList(List<Specimen> specimenList) {
        this.specimenList = specimenList;
        return this;
    }

    public ExtractDto setSpecimenSearchList(List<SpecimenSearch> specimenSearchList) {
        this.specimenSearchList = specimenSearchList;
        return this;
    }

    public ExtractDto createExtractDataDto() {
        return this;
    }
}

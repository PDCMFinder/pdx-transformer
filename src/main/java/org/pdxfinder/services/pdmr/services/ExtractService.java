package org.pdxfinder.services.pdmr.services;

import org.pdxfinder.data.model.*;
import org.pdxfinder.data.model.projection.HistologyProjection;
import org.pdxfinder.services.pdmr.dto.AccessionsDTO;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ExtractService {

    private final Logger log = LoggerFactory.getLogger(ExtractService.class);

    private final DataService dataService;

    public ExtractService(DataService dataService) {
        this.dataService = dataService;
    }

    public OracleDataDto fromPdmrOracle() {

        log.info("Start Loading Oracle data-sets");
        List<PatientInfo> patientList = dataService.getAllPatientInfo();
        List<Sample> samples = dataService.getAllSamples();
        List<HistologyProjection> histologies = dataService.getAllHistologies();
        List<TumorGrades> tumorGradesList = dataService.getAllTumorGrades();
        List<CurrentTherapy> currentTherapies = dataService.getAllCurrentTherapies();
        List<StandardizedRegimens> standardRegimens = dataService.getAllStandardizedRegimens();
        List<ClinicalResponses> clinicalResponses = dataService.getAllClinicalResponses();
        List<PriorTherapies> priorTherapiesList = dataService.getAllPriorTherapies();
        List<TumorGradeStageTypes> tumorGradeStageTypes = dataService.getAllTumorGradeStageTypes();
        List<TissueTypes> tissueTypes = dataService.getAllTissueTypes();
        List<MouseStrains> mouseStrains = dataService.getAllMouseStrains();
        List<ImplantationSites> implantationSites = dataService.getAllImplantationSites();
        List<ProvidedTissueOrigins> tissueOrigins = dataService.getAllProvidedTissueOrigins();
        List<Specimen> specimenList = dataService.getAllPdmrSpecimen();
        List<SpecimenSearch> specimenSearchList = dataService.getAllSpecimenSearch();

        List<OncokbGenePanel> oncokbGenePanels = dataService.getAllOncokbGenePanel();
        List<HugoGeneSymbol> hugoGeneSymbols = dataService.getAllHugoGeneSymbols();
        List<VariantClass> variantClasses = dataService.getAllVariantClasses();
        log.info("Finished Loading Oracle data-sets");

        return new OracleDataDto().setPatientList(patientList)
                .setSamples(samples)
                .setHistologies(histologies)
                .setTumorGradesList(tumorGradesList)
                .setCurrentTherapies(currentTherapies)
                .setStandardRegimens(standardRegimens)
                .setClinicalResponses(clinicalResponses)
                .setPriorTherapiesList(priorTherapiesList)
                .setTumorGradeStageTypes(tumorGradeStageTypes)
                .setTissueTypes(tissueTypes)
                .setMouseStrains(mouseStrains)
                .setImplantationSites(implantationSites)
                .setTissueOrigins(tissueOrigins)
                .setSpecimenList(specimenList)
                .setSpecimenSearchList(specimenSearchList)
                .setOncokbGenePanels(oncokbGenePanels)
                .setHugoGeneSymbols(hugoGeneSymbols)
                .setVariantClasses(variantClasses);
    }

    public AccessionsDTO fromPdmrEna() throws IOException {
        log.info("Loading accession information from ENA");
        Map<String, String> accessions = dataService.getAllAccessionInfo();
        return new AccessionsDTO().setAccessionMap(accessions);
    }


}

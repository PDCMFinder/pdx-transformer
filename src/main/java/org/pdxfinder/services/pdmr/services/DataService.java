package org.pdxfinder.services.pdmr.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pdxfinder.constant.UrlConstants;
import org.pdxfinder.data.model.*;
import org.pdxfinder.data.model.projection.HistologyProjection;
import org.pdxfinder.data.model.repository.*;
import org.pdxfinder.services.common.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataService {

    private final Logger log = LoggerFactory.getLogger(DataService.class);
    private ObjectMapper mapper = new ObjectMapper();

    private final GendersRepository gendersRepository;
    private final SpecimenRepository specimenRepository;
    private final ClinicalResponsesRepo clinicalResponsesRepo;
    private final CurrentTherapyRepo currentTherapyRepo;
    private final ImplantationSitesRepo implantationSitesRepo;
    private final MouseStrainsRepo mouseStrainsRepo;
    private final PatientInfoRepo patientInfoRepo;
    private final PriorTherapiesRepo priorTherapiesRepo;
    private final ProvidedTissueOriginsRepo providedTissueOriginsRepo;
    private final SampleRepo sampleRepo;
    private final SpecimenSearchrepo specimenSearchrepo;
    private final StandardizedRegimensRepo standardizedRegimensRepo;
    private final TissueTypesRepo tissueTypesRepo;

    private final DiagnosisRepo diagnosisRepo;

    private final MeddraRepo meddraRepo;
    private final TumorGradesRepo tumorGradesRepo;
    private final TumorGradeStageTypesRepo tumorGradeStageTypesRepo;
    private final HistologyRepository histologyRepository;
    private OncokbGenePanelRepo oncokbGenePanelRepo;
    private HugoGeneSymbolRepo hugoGeneSymbolRepo;
    private VariantClassRepo variantClassRepo;


    public DataService(GendersRepository gendersRepository,
                       SpecimenRepository specimenRepository,
                       ClinicalResponsesRepo clinicalResponsesRepo,
                       CurrentTherapyRepo currentTherapyRepo,
                       ImplantationSitesRepo implantationSitesRepo,
                       MouseStrainsRepo mouseStrainsRepo,
                       PatientInfoRepo patientInfoRepo,
                       PriorTherapiesRepo priorTherapiesRepo,
                       ProvidedTissueOriginsRepo providedTissueOriginsRepo,
                       SampleRepo sampleRepo,
                       SpecimenSearchrepo specimenSearchrepo,
                       StandardizedRegimensRepo standardizedRegimensRepo,
                       TissueTypesRepo tissueTypesRepo,
                       DiagnosisRepo diagnosisRepo, MeddraRepo meddraRepo, TumorGradesRepo tumorGradesRepo,
                       TumorGradeStageTypesRepo tumorGradeStageTypesRepo,
                       HistologyRepository histologyRepository,
                       OncokbGenePanelRepo oncokbGenePanelRepo,
                       HugoGeneSymbolRepo hugoGeneSymbolRepo,
                       VariantClassRepo variantClassRepo) {
        this.gendersRepository = gendersRepository;
        this.specimenRepository = specimenRepository;
        this.clinicalResponsesRepo = clinicalResponsesRepo;
        this.currentTherapyRepo = currentTherapyRepo;
        this.implantationSitesRepo = implantationSitesRepo;
        this.mouseStrainsRepo = mouseStrainsRepo;
        this.patientInfoRepo = patientInfoRepo;
        this.priorTherapiesRepo = priorTherapiesRepo;
        this.providedTissueOriginsRepo = providedTissueOriginsRepo;
        this.sampleRepo = sampleRepo;
        this.specimenSearchrepo = specimenSearchrepo;
        this.standardizedRegimensRepo = standardizedRegimensRepo;
        this.tissueTypesRepo = tissueTypesRepo;
        this.diagnosisRepo = diagnosisRepo;
        this.meddraRepo = meddraRepo;
        this.tumorGradesRepo = tumorGradesRepo;
        this.tumorGradeStageTypesRepo = tumorGradeStageTypesRepo;
        this.histologyRepository = histologyRepository;
        this.oncokbGenePanelRepo = oncokbGenePanelRepo;
        this.hugoGeneSymbolRepo = hugoGeneSymbolRepo;
        this.variantClassRepo = variantClassRepo;
    }


    public List<TumorGradeStageTypes> getAllTumorGradeStageTypes() {
        log.info("Loading Tumor grade stage types");
        return tumorGradeStageTypesRepo.findAll();
    }

    public List<TumorGrades> getAllTumorGrades() {
        log.info("Loading Tumor grades");
        return tumorGradesRepo.findAll();
    }

    public List<TissueTypes> getAllTissueTypes() {
        log.info("Loading Tissue types");
        return tissueTypesRepo.findAll();
    }
    public List<Diagnoses> getAllDiagnosis() {
        log.info("Loading Diagnosis");
        return diagnosisRepo.findAll();
    }
    public List<MedDRACodes> getAllMeddracodes() {
        log.info("Loading MedDRA codes");
        return meddraRepo.findAll();
    }
    public List<StandardizedRegimens> getAllStandardizedRegimens() {
        log.info("Loading standard regimens");
        return standardizedRegimensRepo.findAll();
    }

    public List<SpecimenSearch> getAllSpecimenSearch() {
        log.info("Loading specimen search");
        return specimenSearchrepo.findAll();
    }

    public List<Sample> getAllSamples() {
        log.info("Loading samples");
        return sampleRepo.findAll();
    }

    public List<ProvidedTissueOrigins> getAllProvidedTissueOrigins() {
        log.info("Loading provided tissues origins");
        return providedTissueOriginsRepo.findAll();
    }

    public List<Genders> getAllGenders() {
        return gendersRepository.findAll();
    }

    public List<Specimen> getAllPdmrSpecimen() {
        log.info("Loading specimen data");
        return specimenRepository.findAll();
    }

    public List<ClinicalResponses> getAllClinicalResponses() {
        log.info("Loading clinical responses");
        return clinicalResponsesRepo.findAll();
    }

    public List<ImplantationSites> getAllImplantationSites() {
        log.info("Loading implantation sites");
        return implantationSitesRepo.findAll();
    }

    public List<CurrentTherapy> getAllCurrentTherapies() {
        log.info("Loading current therapies");
        return currentTherapyRepo.findAll();
    }

    public List<MouseStrains> getAllMouseStrains() {
        log.info("Loading mouse strains");
        return mouseStrainsRepo.findAll();
    }

    public List<PatientInfo> getAllPatientInfo() {
        log.info("Loading patient info");
        return patientInfoRepo.findAll();
    }

    public List<PriorTherapies> getAllPriorTherapies() {
        log.info("Loading prior therapies");
        return priorTherapiesRepo.findAll();
    }

    public List<HistologyProjection> getAllHistologies(){
        log.info("Loading Histology data");
        return   histologyRepository.findAllHistology();
    }

    public List<OncokbGenePanel> getAllOncokbGenePanel(){
        log.info("Loading Hugo oncokb gene panel data");
        return oncokbGenePanelRepo.findAll();
    }

    public List<HugoGeneSymbol> getAllHugoGeneSymbols(){
        log.info("Loading Hugo gene symbol data");
        return hugoGeneSymbolRepo.findAll();
    }

    public List<VariantClass> getAllVariantClasses(){
        log.info("Loading Variant class data");
        return variantClassRepo.findAll();
    }

    public Map<String, String> getAllAccessionInfo() throws IOException {
        String accessionJson = FileUtil.parseJsonURL(UrlConstants.ENA_PDMR_STUDY_JSON_URL);
        List<AccessionInfo> accessionList = mapper.convertValue(mapper.readTree(accessionJson),
                new TypeReference<List<AccessionInfo>>() {});
        Map<String,String> accessionMap = new HashMap<String,String>();
        accessionList.forEach(accession -> {
            accessionMap.putIfAbsent(accession.getSampleAlias().replace("~" ,"-"), accession.getRunAccession().replace("~" ,"-"));
        });
        return accessionMap;








    }

}

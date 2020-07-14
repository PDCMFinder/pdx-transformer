package org.pdxfinder.service;

import org.pdxfinder.*;
import org.pdxfinder.projection.HistologyProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataService {

    private final Logger log = LoggerFactory.getLogger(DataService.class);

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
    private final TumorGradesRepo tumorGradesRepo;
    private final TumorGradeStageTypesRepo tumorGradeStageTypesRepo;
    private final HistologyRepository histologyRepository;

    @Value("${output.directory}")
    private String outputDirectory;


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
                       TumorGradesRepo tumorGradesRepo,
                       TumorGradeStageTypesRepo tumorGradeStageTypesRepo,
                       HistologyRepository histologyRepository) {
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
        this.tumorGradesRepo = tumorGradesRepo;
        this.tumorGradeStageTypesRepo = tumorGradeStageTypesRepo;
        this.histologyRepository = histologyRepository;
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
        log.info("Loading implantatio sites");
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

    public Genders getOneGender(Integer seqNumber) {
        return gendersRepository.findByGenderSeqnbr(seqNumber).orElse(new Genders());
    }
}

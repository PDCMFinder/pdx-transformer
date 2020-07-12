package org.pdxfinder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HistologyService {

    private Logger log = LoggerFactory.getLogger(HistologyService.class);
    private final HistologyRepository histologyRepository;

    public HistologyService(HistologyRepository histologyRepository) {
        this.histologyRepository = histologyRepository;
    }

    public List<Histology> getAllHistologies(){
        log.info("Loading Histology data");
        List<Object[]> histologyData =  histologyRepository.findAllHistology();
        List<String> expectedKeys = Arrays.asList("histologyseqnbr", "sampleseqnbr", "tumorgradeseqnbr", "tumorcontent", "necrosis",
                                                  "stromal", "inflammatorycellseqnbr", "pathologynotes", "lowmagimagemimetype", "lowmagimagefilename", "highmagimagefilename");
        return convertObjectsToMaps(histologyData, expectedKeys);
    }

    public Histology getOneHistology(String seqNumber){
        return histologyRepository.findByHistologyseqnbr(seqNumber).orElse(new Histology());
    }

    public List<Histology> convertObjectsToMaps(List<Object[]> dataList, List<String> keys){
        List<Map<String, String>> result = new ArrayList<>();
        for (Object[] data : dataList) {
            Map<String, String> dataMap = new HashMap<>();
            int count = 0;
            for (Object content : data){
                dataMap.put(keys.get(count), String.valueOf(content));
                count++;
            }
            result.add(dataMap);
        }

        List<Histology> histologies = new ArrayList<>();
        result.forEach(map -> histologies.add(
                new Histology()
                .setHistologyseqnbr(map.get("histologyseqnbr"))
                .setSampleseqnbr(map.get("sampleseqnbr"))
                .setTumorgradeseqnbr(map.get("tumorgradeseqnbr"))
                .setTumorcontent(map.get("tumorcontent"))
                .setNecrosis(map.get("necrosis"))
                .setStromal(map.get("stromal"))
                .setInflammatorycellseqnbr(map.get("inflammatorycellseqnbr"))
                .setPathologynotes(map.get("pathologynotes"))
                .setLowmagimagemimetype(map.get("lowmagimagemimetype"))
                .setLowmagimagefilename(map.get("lowmagimagefilename"))
                .setHighmagimagefilename(map.get("highmagimagefilename"))
        ));
        return histologies;
    }
}

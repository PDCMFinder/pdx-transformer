package org.pdxfinder.services.pdmr.dto;

import java.util.Map;

public class AccessionsDTO {

    private Map<String, String> accessionMap;


    public Map<String, String> getAccessionMap() {
        return accessionMap;
    }

    public AccessionsDTO setAccessionMap(Map<String,String> accessionList) {
        this.accessionMap = accessionList;
        return this;
    }
}

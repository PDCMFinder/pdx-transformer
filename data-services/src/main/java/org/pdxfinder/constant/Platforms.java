package org.pdxfinder.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Platforms {

    PDMR_ONKOKB_PROTOCOL("OncoKB Gene Panel","https://pdmr.cancer.gov/content/docs/MCCRD_SOP0053_Generating_oncoKB_Report.pdf"),
    CTP_JAX("CTP","/platform/jax-ctp/"),
    TRUESEQ_JAX("Truseq_JAX","/platform/jax-truseq/"),
    WHOLE_EXOMEJAX("Whole_Exome","/platform/jax-whole-exome/");

    private final String tech;
    private final String url;
    private static final Map<String, String> MAP = new HashMap<>();

    Platforms(String tech, String url) {
        this.tech = tech;
        this.url = url;
    }

    public String get() {
        return tech;
    }

    public String url() {
        return url;
    }

    public static String urlFor(String tech) {
        return Objects.toString(MAP.get(tech), DataConstants.EMPTY);
    }

    static {
        for (Platforms s : Platforms.values()) {
            MAP.put(s.tech, s.url);
        }
    }
}


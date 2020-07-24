package org.pdxfinder.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Platforms {

    PDMR_ONKOKB(DataConstants.TECH_PDMR_ONKOKB, UrlConstants.PDMR_ONKOKB_URL),
    JAX_CTP(DataConstants.TECH_JAX_CTP, UrlConstants.JAX_CTP_URL),
    JAX_TRUESEQ(DataConstants.TECH_JAX_TRUSEQ, UrlConstants.JAX_TRUESEQ_URL),
    JAX_WHOLE_EXOME(DataConstants.TECH_JAX_EXOME, UrlConstants.JAX_WHOLE_EXOME_URL);

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


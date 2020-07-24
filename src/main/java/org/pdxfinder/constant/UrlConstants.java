package org.pdxfinder.constant;

public class UrlConstants {

    private UrlConstants(){
        // Never called
    }

    public static final String JAX_METADATA = "http://tumor.informatics.jax.org/PDXInfo/JSONData.do?allModels=gimme";

    public static final String JAX_MUTATION = "http://tumor.informatics.jax.org/PDXInfo/JSONData.do?modelVariation=";

    public static final String JAX_HISTOLOGY = "http://tumor.informatics.jax.org/PDXInfo/JSONData.do?modelHistology=";

    public static final String JAX_CNA = "http://tumor.informatics.jax.org/PDXInfo/JSONData.do?modelCNV=";

    public static final String JAX_RNA_SEQ = "http://tumor.informatics.jax.org/PDXInfo/JSONData.do?modelExpression=";



    public static final String JAX_SOURCE_URL = "http://tumor.informatics.jax.org/mtbwi/pdxDetails.do?modelID=";

    public static final String JAX_CONTACT = "http://tumor.informatics.jax.org/mtbwi/pdxRequest.do?mice=";

    public static final String JAX_CTP_URL = "/platform/jax-ctp/";

    public static final String JAX_TRUESEQ_URL = "/platform/jax-truseq/";

    public static final String JAX_WHOLE_EXOME_URL = "/platform/jax-whole-exome/";



    public static final String PDMR_CONTACT_URL = "https://pdmr.cancer.gov/request/default.htm";

    public static final String PDMR_SOURCE_URL_PREFIX = "https://pdmdb.cancer.gov/pls/apex/f?p=101:4:0::NO:4:P4_SPECIMENSEQNBR:";

    public static final String PDMR_ONKOKB_URL = "https://pdmr.cancer.gov/content/docs/MCCRD_SOP0053_Generating_oncoKB_Report.pdf";


}

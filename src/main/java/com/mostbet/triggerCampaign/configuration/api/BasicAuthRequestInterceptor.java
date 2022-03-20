
package com.mostbet.triggerCampaign.configuration.api;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class BasicAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        String userToken = "eyJhbGciOiJSUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWQiOjQzMjc2MDYwLCJleHAiOjE4MDU0OTAxNzMsImlhdCI6MTY0NzgxMDE3M30.KoObnD262qI0uFsAn-CQcDH0GLMJVjboJFeMcuQfjujMCwaC82lgJU66wqS3V9OTy1ZGRxPhHWp98LHvihpiwwBoU37hoaSknMGSx47VdTdtAkq2t2FiRANVn0sKL2fJQHl5gAe7l7wa2hwBTnaX_giIivlcAjg8DoEzpCUS-e4";
        template.header("Authorization", "Bearer " + userToken);
    }
}

package com.essContext.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
* @ClassName: LegalPersonRequest
* @Description: 
* @author liyan 
* @date 2020/7/25
* @version V1.0
*/ 
@Data
@NoArgsConstructor
public class LegalPersonRequest {
    @NonNull
    private String type;
    @NonNull
    private String companyName;
    @NonNull
    private String companyCode;
    @NonNull
    private String name;
    @NonNull
    private String idType;
    @NonNull
    private String idCode;

}


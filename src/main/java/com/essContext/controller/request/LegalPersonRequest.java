package com.essContext.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;

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

    @NotBlank(message = "法定代表人姓名不能为空")
    private String name;

    @NonNull
    private String idType;

    @NonNull
    private String idCode;
}


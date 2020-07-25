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

    @NotBlank(message = "法人类型不能为空")
    private String type;

    @NotBlank(message = "公司名称不能为空")
    private String companyName;

    @NotBlank(message = "统一信用代码不能为空")
    private String companyCode;

    @NotBlank(message = "法定代表人姓名不能为空")
    private String name;

    @NotBlank(message = "证件类型不能为空")
    private String idType;

    @NotBlank(message = "证件号码不能为空")
    private String idCode;
}


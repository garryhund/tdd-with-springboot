package com.essContext.domain.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LegalPerson implements Serializable {
    private String type;
    private String companyName;
    private String companyCode;
    private String name;
    private String idType;
    private String idCode;
    private String id;
}

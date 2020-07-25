package com.essContext.domain.service;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;


    /**
    * 注册
    * @param
    * @return
    * @throws
    * @author liyan
    * @time 2020/7/25 14:33
    */
    public LegalPerson register(LegalPersonRequest request) {
        LegalPerson legalPerson = LegalPerson.builder()
                .type(request.getType())
                .companyName(request.getCompanyName())
                .companyCode(request.getCompanyCode())
                .name(request.getName())
                .idType(request.getIdType())
                .idCode(request.getIdCode())
                .build();
        return legalPersonRepository.save(legalPerson);
    }
}

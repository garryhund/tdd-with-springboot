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
    public String register(LegalPersonRequest request) {

        // 1. 构建法人对象
        LegalPerson legalPerson = LegalPerson.builder()
                .type(request.getType())
                .companyName(request.getCompanyName())
                .companyCode(request.getCompanyCode())
                .name(request.getName())
                .idType(request.getIdType())
                .idCode(request.getIdCode())
                .build();

        // 2. 工商核验法人信息


        // 3. 保存用户信息
        String userId = legalPersonRepository.save(legalPerson);

        // 4. 异步循环处理同步国家平台

        // 5. 返回应答
        return userId;
    }
}

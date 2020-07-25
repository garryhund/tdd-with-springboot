package com.essContext.controller;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.service.LegalPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @ClassName: LegalPersonController
* @Description: 
* @author liyan 
* @date 2020/7/25
* @version V1.0
*/ 
@Slf4j
@RestController
@RequestMapping(value = "/api/legalPerson")
public class LegalPersonController {
    @Autowired
    LegalPersonService legalPersonService;

    @PostMapping("/register")
    public String register(@Validated @RequestBody LegalPersonRequest request) throws Exception {
        log.info("开始执行法人注册");
        String userId = legalPersonService.register(request);
        return userId;
    }
}

package com.essContext;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.service.LegalPersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest extends BaseTest {

    @Autowired
    LegalPersonService legalPersonService;

    @Test
    @DisplayName("正常注册")
    void registerTest() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setCompanyName("bbb");
        legalPersonRequest.setType("123");
        legalPersonRequest.setIdType("111");
        legalPersonRequest.setCompanyCode("0001");
        legalPersonRequest.setName("name");
        String userId = legalPersonService.register(legalPersonRequest);
        assert(userId.length() > 0);
        System.out.println(userId);
    }

    @Test
    @DisplayName("测试用户已注册")
    void registerTest2() {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setCompanyName("bbb");
        legalPersonRequest.setCompanyCode("1234");
        legalPersonRequest.setType("123");
        legalPersonRequest.setIdType("111");
        String userId = legalPersonService.register(legalPersonRequest);
        assert(userId.length() > 0);
        System.out.println(userId);

        Exception exception = assertThrows(
                RuntimeException.class, () -> legalPersonService.register(legalPersonRequest));
        assertTrue(exception.getMessage().contains("用户已注册"));
    }
}

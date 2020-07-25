package com.essContext.user;

import com.essContext.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.essContext.BaseRequestBody.body;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest extends BaseTest {
    @Test
    @DisplayName("正常注册流程")
    void should_return_success_given_legalPersonInfo_when_register() {
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "中国一汽")
                        .put("companyCode", "JLCC00000000000001")
                        .put("name", "张建国")
                        .put("idType", 1)
                        .put("idCode", "11111111111111111")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .body("type", equalTo("1"))
                .statusCode(200);
    }

    @Test
    @DisplayName("缺失法定代表人姓名")
    void test2() {
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "中国一汽")
                        .put("companyCode", "JLCC00000000000001")
                        .put("idType", 1)
                        .put("idCode", "11111111111111111")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .body("type", equalTo("1"))
                .statusCode(200);
    }

    @Test
    @DisplayName("测试用户已存在")
    void test3() {
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "中国一汽")
                        .put("companyCode", "JLCC00000000000001")
                        .put("name", "张建国")
                        .put("idType", 1)
                        .put("idCode", "11111111111111111")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .body("type", equalTo("1"))
                .statusCode(200);
        given().contentType("application/json")
                .body(body()
                        .put("type", 1)
                        .put("companyName", "中国一汽")
                        .put("companyCode", "JLCC00000000000001")
                        .put("name", "张建国")
                        .put("idType", 1)
                        .put("idCode", "11111111111111111")
                        .build())
                .when().post("/api/legalPerson/register")
                .then().log().body()
                .body("type", equalTo("1"))
                .statusCode(200);
    }
}

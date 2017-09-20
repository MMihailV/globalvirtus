package com.jdriven.ng2boot.controlerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationControllerTest {
    @Test
    public void create_success() {
       /* given().
                param("username", "newuser").
                param("email", "newusergmail.com").
                param("password", "newuser").
                when().
                        post("/registration/create").
                then()
                    .statusCode(205);*/
    }
}

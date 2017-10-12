package com.jdriven.ng2boot.controlerTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Test
    public void getUserByLogin() {
        /*given().
                        param("login", "newuser").
                when().
                        get("/user/user").
                then()
                .statusCode(200);*/
        //assertTrue(token.length() > 0);
    }
}

package com.jdriven.ng2boot.controlerTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Test
    public void login_success() {
       /* String token = given().
                        param("username", "test").
                        param("password", "test").
                when().
                        post("/authenticate/login").
                then()
                    .extract()
                    .path("token");

        assertTrue(token.length() > 0);*/
    }

    @Test
    public void login_failed() {
       /* String token = given().
                        param("username", "testt").
                        param("password", "test").
                    when().
                        post("/authenticate/login").
                    then()
                        .extract()
                        .path("token");

        assertTrue(token.length() == 0);*/
    }
}

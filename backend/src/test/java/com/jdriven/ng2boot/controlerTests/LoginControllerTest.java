package com.jdriven.ng2boot.controlerTests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
/*
    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/authenticate/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }*/

    @Test
    public void login() {
             /*   given().
                        param("username", "test").
                        param("password", "test").
                when().
                        post("/authenticate/login").
                then().
                        statusCode(200);*/
    }
}

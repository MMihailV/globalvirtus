package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.User;
import com.jdriven.ng2boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("authenticate")
@CrossOrigin(origins = {"http://localhost:4200/#/"})
public class LoginController {

    @Autowired
    private IUserService userService;

    //@PostMapping("login")
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> login(
            @RequestParam(value="username") String username,
            @RequestParam(value="password")String password
    ) {
        String token = userService.getUserByLogin(username, password);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        if (!token.equals("")) return new ResponseEntity<String>("{\"token\": \"" + token + "\"}", httpHeaders, HttpStatus.OK);
        else return new ResponseEntity<String>("{\"token\": \"\"}", httpHeaders, HttpStatus.UNAUTHORIZED);
    }
}

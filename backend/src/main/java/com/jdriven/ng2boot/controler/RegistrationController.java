package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("registration")
//@CrossOrigin(origins = {"http://localhost:4200/#/"})
@CrossOrigin
public class RegistrationController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<String> create(
            @RequestParam(value="username") String username,
            @RequestParam(value="email") String email,
            @RequestParam(value="password")String password
    ) {
        boolean result = userService.createUser(username, email, password);
        if (result) return new ResponseEntity<String>(HttpStatus.RESET_CONTENT);
        else return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}

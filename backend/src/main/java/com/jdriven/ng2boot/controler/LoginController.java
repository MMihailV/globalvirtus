package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.User;
import com.jdriven.ng2boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("authenticate")
@CrossOrigin(origins = {"http://localhost:4200/#/"})
public class LoginController {
   /* @Autowired
    private IUserService userService;
    @GetMapping("login")
    public ResponseEntity<Boolean> login(@RequestParam("login") String login, String password) {
        return new ResponseEntity<Boolean>(userService.getUserByLogin(login, password), HttpStatus.OK);
    }*/
}

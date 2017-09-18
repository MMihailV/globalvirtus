package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.User;
import com.jdriven.ng2boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("authenticate")
@CrossOrigin(origins = {"http://localhost:4200/#/"})
public class LoginController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ResponseEntity<Void> login(
            @RequestParam(value="username") String username,
            @RequestParam(value="password")String password
    ) {
        if (userService.getUserByLogin(username, password)) return new ResponseEntity<Void>(HttpStatus.OK);
        else return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }
}

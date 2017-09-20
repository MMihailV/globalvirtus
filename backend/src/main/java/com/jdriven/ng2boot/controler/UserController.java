package com.jdriven.ng2boot.controler;
/*
import com.jdriven.ng2boot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdriven.ng2boot.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @RequestMapping("/user")
    @ResponseBody
    public String test() {
        User user = new User();
        user.setFirstName("Yuri");
        user.setLastName("Grishechkin");
        user.setLogin("10pik");
        user.setPassword("123456");
        user.setEmail("yrik_1995@mail.ru");
        user.setFK_Role(1L);
        UserRepository.save(user);
        User p2 = UserRepository.findOne(user.getId());
        System.out.println("User " + p2.getId() + " added!");
        UserRepository.delete(user);
        System.out.println("User " + p2.getId() + " deleted!");
        return "OK!";
    }
}
*/


import java.util.List;

import com.jdriven.ng2boot.domain.User;
import com.jdriven.ng2boot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200/#/"})
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("article")
    public ResponseEntity<User> getUserById(@RequestParam("id") String id) {
        User user = userService.getUserById(Integer.parseInt(id));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @GetMapping("all-articles")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }
    @PostMapping("article")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
        boolean flag = userService.createUser(user.getLogin(), user.getEmail(), user.getPassword());
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("article")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @DeleteMapping("article")
    public ResponseEntity<Void> deleteUser(@RequestParam("id") String id) {
        userService.deleteUser(Integer.parseInt(id));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
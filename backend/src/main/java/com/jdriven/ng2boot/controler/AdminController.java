package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdriven.ng2boot.repository.AdminRepository;

@Controller
public class AdminController {

    @Autowired
    private AdminRepository AdminRepository;

    @RequestMapping("/admin")
    @ResponseBody
    public String test() {
        Admin admin = new Admin();
        admin.setFirstName("Yuri");
        admin.setLastName("Grishechkin");
        admin.setLogin("10pik");
        admin.setPassword("123456");
        admin.setEmail("yrik_1995@mail.ru");
        admin.setFK_Role(1L);
        AdminRepository.save(admin);
        Admin p2 = AdminRepository.findOne(admin.getId());
        System.out.println("Admin " + p2.getId() + " added!");
        AdminRepository.delete(admin);
        System.out.println("Admin " + p2.getId() + " deleted!");
        return "OK!";
    }
}
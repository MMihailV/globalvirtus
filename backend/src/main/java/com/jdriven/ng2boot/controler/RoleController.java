package com.jdriven.ng2boot.controler;

import com.jdriven.ng2boot.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jdriven.ng2boot.repository.RoleRepository;

@Controller
public class RoleController {

    @Autowired
    private RoleRepository RoleRepository;

    @RequestMapping("/role")
    @ResponseBody
    public String test() {
        Role role = new Role();
        role.setRoleName("admin");
        RoleRepository.save(role);
        Role r2 = RoleRepository.findOne(role.getId());
        System.out.println("Role " + r2.getRoleName() + " added!");
        RoleRepository.delete(role);
        System.out.println("Role " + r2.getRoleName() + " deleted!");
        return "OK!";
    }
}
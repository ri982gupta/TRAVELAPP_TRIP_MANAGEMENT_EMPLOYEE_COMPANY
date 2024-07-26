package com.sjprogramming.SpringBootDATADB.demo.resource;

import com.sjprogramming.SpringBootDATADB.demo.persistence.Login;
import com.sjprogramming.SpringBootDATADB.demo.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginResource {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public List<Login> getAllLogins() {
        return loginService.getAllLogins();
    }

    @GetMapping("/{id}")
    public Login getLoginById(@PathVariable Long id) {
        return loginService.getLoginById(id);
    }
    
    @GetMapping("/{empId}")
    public Login getLoginByEmpId(@PathVariable Long empId) {
        return loginService.getLoginByEmpId(empId);
    }

    @PostMapping
    public Login createLogin(@RequestBody Login login) {
        return loginService.createLogin(login);
    }

    @PutMapping("/{id}")
    public Login updateLogin(@PathVariable Long id, @RequestBody Login login) {
        return loginService.updateLogin(id, login);
    }

    @DeleteMapping("/{id}")
    public boolean deleteLogin(@PathVariable Long id) {
        return loginService.deleteLogin(id);
    }
}

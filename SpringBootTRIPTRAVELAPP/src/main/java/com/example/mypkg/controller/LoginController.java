package com.example.mypkg.controller;

import com.example.mypkg.model.Login;
import com.example.mypkg.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Login>> getAllData() {
    	try {
        List<Login> loginList = loginService.getAllLogin();
        return new ResponseEntity<>(loginList, HttpStatus.OK);
    	} catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/save")
    
    public ResponseEntity<Login> addData(@RequestBody Login login) {
    	try {
    		System.out.println("Login added:");
        Login newLogin = loginService.addLogin(login);
        return new ResponseEntity<>(newLogin, HttpStatus.CREATED);
    	 } catch (IOException e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    
    @GetMapping("/{empId}")
    public ResponseEntity<List<Login>> getDataByEmpId(@PathVariable Long empId) {
        try {
            List<Login> loginList = loginService.getLoginByEmpId(empId);
            return new ResponseEntity<>(loginList, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/login")
    public ResponseEntity<Login> getLoginByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        try {
            Login login = loginService.getLoginByEmailAndPassword(email, password);
            if (login != null) {
                return ResponseEntity.ok().body(login);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

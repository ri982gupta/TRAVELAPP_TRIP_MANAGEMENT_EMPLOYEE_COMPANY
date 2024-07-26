package com.sjprogramming.SpringBootDATADB.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.SpringBootDATADB.demo.persistence.Login;
import com.sjprogramming.SpringBootDATADB.demo.persistence.LoginRepository;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    public Login getLoginById(Long id) {
        return loginRepository.findById(id).orElse(null);
    }
    
    public Login getLoginByEmpId(Long empId) {
        return loginRepository.findById(empId).orElse(null);
    }

    public Login createLogin(Login login) {
        return loginRepository.save(login);
    }

    public Login updateLogin(Long id, Login login) {
    	Login existingLogin = loginRepository.findById(id).orElse(null);
        if (existingLogin != null) {
        	existingLogin.setId(login.getId());
            return loginRepository.save(existingLogin);
        }
        return null;
    }

    public boolean deleteLogin(Long id) {
    	Login existingLogin = loginRepository.findById(id).orElse(null);
        if (existingLogin != null) {
        	loginRepository.delete(existingLogin);
            return true;
        }
        return false;
    }
}





    
    
    

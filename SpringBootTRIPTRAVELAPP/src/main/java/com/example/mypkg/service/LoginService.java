package com.example.mypkg.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.mypkg.model.Login;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class LoginService {
	private static final String FILE_PATH = "login.json";
	
	public List<Login> getAllLogin() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            return mapper.readValue(file, new TypeReference<List<Login>>() {});
        }
        return new ArrayList<>();
    }

    public Login addLogin(Login login) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        List<Login> loginList = getAllLogin();
        loginList.add(login);
        
        
     // Print the dataList to console
        System.out.println("Login added:");
        for (Login d : loginList) {
            System.out.println(d.toString()); // Assuming Data class overrides toString() method
        }

        writer.writeValue(file, loginList);
        return login;
    }
    
    public List<Login> getLoginByEmpId(Long empId) throws IOException {
        List<Login> allLogin = getAllLogin();
        return allLogin.stream()
                .filter(login -> empId.equals(login.getEmpId()))
                .collect(Collectors.toList());
    }
    
 // This method will retrieve a login by email and password
    public Login getLoginByEmailAndPassword(String email, String password) throws IOException {
        List<Login> allLogins = getAllLogin();
        Optional<Login> matchingLogin = allLogins.stream()
                .filter(login -> email.equals(login.getEmail()) && password.equals(login.getPassword()))
                .findFirst();
        return matchingLogin.orElse(null);
    }

}

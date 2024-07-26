package com.example.mypkg.controller;

import com.example.mypkg.model.FormData;
import com.example.mypkg.service.FormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/formData")
public class FormDataController {

    private final FormDataService formDataService;

    @Autowired
    public FormDataController(FormDataService formDataService) {
        this.formDataService = formDataService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<FormData>> getAllFormData() {
        try {
            List<FormData> formDataList = formDataService.getAllFormData();
            return new ResponseEntity<>(formDataList, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<FormData> saveFormData(@RequestBody FormData formData) {
        try {
            FormData savedFormData = formDataService.saveFormData(formData);
            return new ResponseEntity<>(savedFormData, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

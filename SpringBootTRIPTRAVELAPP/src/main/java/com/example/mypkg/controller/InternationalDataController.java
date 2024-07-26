package com.example.mypkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mypkg.model.InternationalData;
import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.service.InternationalDataService;

@RestController
@RequestMapping("/api/international")
public class InternationalDataController {

    @Autowired
    private InternationalDataService internationalDataService;

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> saveInternationalData(@RequestBody InternationalData internationalData) {
        ResponseModel responseModel = internationalDataService.addInternationalData(internationalData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> getInternationalData(@PathVariable Long id) {
        ResponseModel responseModel = internationalDataService.fetchInternationalDataDetails(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-by-emp/{empId}")
    public ResponseEntity<ResponseModel> getInternationalDataByEmpId(@PathVariable String empId) {
        ResponseModel responseModel = internationalDataService.getInternationalDataByEmpId(empId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> getAllInternationalData() {
        ResponseModel responseModel = internationalDataService.fetchAllInternationalData();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseModel> updateInternationalData(@RequestBody InternationalData internationalData) {
        ResponseModel responseModel = internationalDataService.updateInternationalData(internationalData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteInternationalData(@PathVariable Long id) {
        ResponseModel responseModel = internationalDataService.deleteInternationalData(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

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

import com.example.mypkg.model.DomesticData;
import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.service.DomesticDataService;

@RestController
@RequestMapping("/api/domestic")
public class DomesticDataController {

    @Autowired
    private DomesticDataService domesticDataService;

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> saveDomesticData(@RequestBody DomesticData domesticData) {
        ResponseModel responseModel = domesticDataService.addDomesticData(domesticData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> getDomesticData(@PathVariable Long id) {
        ResponseModel responseModel = domesticDataService.fetchDomesticDataDetails(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-by-emp/{empId}")
    public ResponseEntity<ResponseModel> getDomesticDataByEmpId(@PathVariable String empId) {
        ResponseModel responseModel = domesticDataService.getDomesticDataByEmpId(empId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> getAllDomesticData() {
        ResponseModel responseModel = domesticDataService.fetchAllDomesticData();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseModel> updateDomesticData(@RequestBody DomesticData domesticData) {
        ResponseModel responseModel = domesticDataService.updateDomesticData(domesticData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteDomesticData(@PathVariable Long id) {
        ResponseModel responseModel = domesticDataService.deleteDomesticData(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

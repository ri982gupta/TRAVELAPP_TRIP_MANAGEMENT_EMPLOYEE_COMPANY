package com.example.mypkg.controller;

import com.example.mypkg.model.Data;
import com.example.mypkg.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Data>> getAllData() {
    	try {
        List<Data> dataList = dataService.getAllData();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    	} catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/save")
    
    public ResponseEntity<Data> addData(@RequestBody Data data) {
    	try {
    		System.out.println("Data added2:");
        Data newData = dataService.addData(data);
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    	 } catch (IOException e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }
    
//    @GetMapping("/byEmpId/{empId}")
//    public ResponseEntity<List<Data>> getDataByEmpId(@PathVariable Long empId) {
//        try {
//            List<Data> dataList = dataService.getDataByEmpId(empId);
//            return new ResponseEntity<>(dataList, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}

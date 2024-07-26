package com.example.mypkg.controller;

import com.example.mypkg.model.EmployeeTravelRequest;
import com.example.mypkg.model.ResponseModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.mypkg.service.EmployeeTravelRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/travel")
public class EmployeeTravelRequestController {

    @Autowired
    private EmployeeTravelRequestService travelService;

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addEmployeeTravelRequest(@RequestBody EmployeeTravelRequest employeeTravelRequest) {
       ResponseModel responseModel = travelService.addEmployeeTravelRequest(employeeTravelRequest);
       return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> fetchAllEmployeeTravelRequests() {
    	ResponseModel responseModel = travelService.fetchAllEmployeeTravelRequest();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> fetchEmployeeTravelRequestDetails(@PathVariable("id") Long employeeTravelRequestId) {
    	ResponseModel responseModel = travelService.fetchEmployeeTravelRequestDetails(employeeTravelRequestId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseModel> updateEmployeeTravelRequest(@RequestBody EmployeeTravelRequest employeeTravelRequest) {
    	ResponseModel responseModel = travelService.updateEmployeeTravelRequest(employeeTravelRequest);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteEmployeeTravelRequest(@PathVariable("id") Long employeeTravelRequestId) {
    	ResponseModel responseModel = travelService.deleteEmployeeTravelRequest(employeeTravelRequestId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/byEmpId/{empId}")
    public ResponseEntity<ResponseModel> getEmployeeTravelRequestByEmpId(@PathVariable("empId") String employeeId) {
    	ResponseModel responseModel = travelService.getEmployeeTravelRequestByEmpId(employeeId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

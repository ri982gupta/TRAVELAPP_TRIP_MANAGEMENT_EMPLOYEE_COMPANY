package com.example.mypkg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelRequest;
import com.example.mypkg.service.TravelRequestService;

@RestController
@RequestMapping("/api/travel-requests")
public class TravelRequestController {

    @Autowired
    private TravelRequestService travelRequestService;

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> addTravelRequest(@RequestBody TravelRequest travelRequest) {
        ResponseModel responseModel = travelRequestService.addTravelRequest(travelRequest);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> fetchAllTravelRequests() {
        ResponseModel responseModel = travelRequestService.fetchAllTravelRequests();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> fetchTravelRequestDetails(@PathVariable("id") Long travelRequestId) {
        ResponseModel responseModel = travelRequestService.fetchTravelRequestDetails(travelRequestId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseModel> updateTravelRequest(@PathVariable("id") Long travelRequestId, @RequestBody TravelRequest travelRequest) {
        travelRequest.setId(travelRequestId); // Set the ID from the path variable
        ResponseModel responseModel = travelRequestService.updateTravelRequest(travelRequest);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteTravelRequest(@PathVariable("id") Long travelRequestId) {
        ResponseModel responseModel = travelRequestService.deleteTravelRequest(travelRequestId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

//    @GetMapping("/emp/{empId}")
//    public ResponseEntity<ResponseModel> getTravelRequestsByEmpId(@PathVariable("empId") String empId) {
//        ResponseModel responseModel = travelRequestService.getTravelRequestsByEmpId(empId);
//        return new ResponseEntity<>(responseModel, HttpStatus.OK);
//    }
}

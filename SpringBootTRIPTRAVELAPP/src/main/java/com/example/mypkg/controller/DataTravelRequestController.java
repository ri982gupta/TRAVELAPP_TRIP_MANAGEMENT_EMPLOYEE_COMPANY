package com.example.mypkg.controller;

import com.example.mypkg.model.DataTravelRequest;
import com.example.mypkg.service.DataTravelRequestService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data_travel_requests")
public class DataTravelRequestController {

    @Autowired
    private DataTravelRequestService dataTravelRequestService;

    @PostMapping("/save")
    public ResponseEntity<String> saveDataTravelRequest(@RequestBody DataTravelRequest dataTravelRequest) {
        try {
            dataTravelRequestService.saveDataTravelRequest(dataTravelRequest);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<DataTravelRequest>> getAllDataTravelRequests() {
        List<DataTravelRequest> dataTravelRequests = dataTravelRequestService.getAllDataTravelRequests();
        return ResponseEntity.ok(dataTravelRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataTravelRequest> getDataTravelRequestById(@PathVariable("id") Long id) {
        DataTravelRequest dataTravelRequest = dataTravelRequestService.getDataTravelRequestById(id);
        if (dataTravelRequest != null) {
            return ResponseEntity.ok(dataTravelRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

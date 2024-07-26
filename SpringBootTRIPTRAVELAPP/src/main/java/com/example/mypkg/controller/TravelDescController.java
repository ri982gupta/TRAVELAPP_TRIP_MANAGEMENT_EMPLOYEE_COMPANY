package com.example.mypkg.controller;

import com.example.mypkg.model.TravelDesc;
import com.example.mypkg.service.TravelDescService;

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
@RequestMapping("/api/travel_desc")
public class TravelDescController {

    @Autowired
    private TravelDescService travelDescService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTravelDesc(@RequestBody TravelDesc travelDesc) {
        try {
        	travelDescService.saveTravelDesc(travelDesc);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<TravelDesc>> getAllTravelDesc() {
        List<TravelDesc> travelDesc = travelDescService.getAllTravelDesc();
        return ResponseEntity.ok(travelDesc);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TravelDesc> getTravelDescById(@PathVariable("id") Long id) {
    	TravelDesc travelDesc = travelDescService.getTravelDescById(id);
        if (travelDesc != null) {
            return ResponseEntity.ok(travelDesc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/empId/{empId}")
    public ResponseEntity<TravelDesc> getTravelDescByEmpId(@PathVariable("empId") Long empId) {
        TravelDesc travelDesc = travelDescService.getTravelDescByEmpId(empId); // Corrected method call
        if (travelDesc != null) {
            return ResponseEntity.ok(travelDesc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

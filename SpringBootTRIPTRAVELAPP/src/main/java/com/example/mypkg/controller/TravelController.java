package com.example.mypkg.controller;

import com.example.mypkg.model.Travel;
import com.example.mypkg.service.TravelService;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/Single_travel")
public class TravelController {

    @Autowired
    private TravelService travelService;
    
    private static final Logger logger = LoggerFactory.getLogger(TravelController.class);


    @PostMapping("/save")
    public ResponseEntity<String> saveTravel(@RequestBody Travel travel) {
        try {
            travelService.saveTravel(travel);
            logger.info("Received travel: {}", travel);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving data: " + e.getMessage());
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Travel>> getAllTravel() {
        List<Travel> travels = travelService.getAllTravel();
        return ResponseEntity.ok(travels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        Travel travel = travelService.getTravelById(id);
        if (travel != null) {
            return ResponseEntity.ok(travel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

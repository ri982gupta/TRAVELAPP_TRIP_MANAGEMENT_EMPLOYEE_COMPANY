package com.example.mypkg.controller;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelData;
import com.example.mypkg.service.TravelDataService;
import com.example.mypkg.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travel")
public class TravelDataController {

    @Autowired
    private TravelDataService travelDataService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTravelData(@RequestBody TravelData travelData) {
        try {
            ResponseModel savedData = travelDataService.addTravelData(travelData);
            return ResponseEntity.ok().body(savedData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_MESSAGE);
        }
    }
    
    
    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> getAllTravelData() {
        ResponseModel responseModel = travelDataService.fetchAllTravelData();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getTravelData(@PathVariable Long id) {
        try {
            ResponseModel data = travelDataService.fetchTravelDataDetails(id);
            return ResponseEntity.ok().body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_MESSAGE);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTravelData(@RequestBody TravelData travelData) {
        try {
            ResponseModel updatedData = travelDataService.updateTravelData(travelData);
            return ResponseEntity.ok().body(updatedData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_MESSAGE);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTravelData(@PathVariable Long id) {
        try {
            ResponseModel deletedData = travelDataService.deleteTravelData(id);
            return ResponseEntity.ok().body(deletedData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_MESSAGE);
        }
    }
}


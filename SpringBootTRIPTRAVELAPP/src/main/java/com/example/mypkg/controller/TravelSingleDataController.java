package com.example.mypkg.controller;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelSingleData;
import com.example.mypkg.service.TravelSingleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travelSingle")
public class TravelSingleDataController {

    @Autowired
    private TravelSingleDataService travelSingleDataService;

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> saveTravelData(@RequestBody TravelSingleData travelData) {
        ResponseModel responseModel = travelSingleDataService.saveTravelData(travelData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> getTravelDataById(@PathVariable("id") Long id) {
        ResponseModel responseModel = travelSingleDataService.getTravelDataById(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> getAllTravelData() {
        ResponseModel responseModel = travelSingleDataService.getAllTravelData();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }


    
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseModel> updateTravelData(@PathVariable("id") Long id, @RequestBody TravelSingleData travelData) {
    	travelData.setId(id); 
        ResponseModel responseModel = travelSingleDataService.updateTravelData(travelData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteTravelData(@PathVariable Long id) {
        ResponseModel responseModel = travelSingleDataService.deleteTravelData(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

package com.example.mypkg.controller;

import com.example.mypkg.model.ApplyForFormData;
import com.example.mypkg.model.Login;
import com.example.mypkg.service.ApplyForFormDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/applyForFormData")
public class ApplyForFormDataController {

    private final ApplyForFormDataService applyForFormDataService;

    @Autowired
    public ApplyForFormDataController(ApplyForFormDataService applyForFormDataService) {
        this.applyForFormDataService = applyForFormDataService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ApplyForFormData>> getAllApplyForFormData() {
        try {
            List<ApplyForFormData> applyForFormDataList = applyForFormDataService.getAllApplyForFormData();
            return new ResponseEntity<>(applyForFormDataList, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ApplyForFormData> saveApplyForFormData(@RequestBody ApplyForFormData applyForFormData) {
        try {
            ApplyForFormData savedApplyForFormData = applyForFormDataService.saveApplyForFormData(applyForFormData);
            return new ResponseEntity<>(savedApplyForFormData, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @GetMapping("/byEmpId/{empId}")
//    public ResponseEntity<List<ApplyForFormData>> getApplyForFormDataByEmpId(@PathVariable Long empId) {
//        try {
//            List<ApplyForFormData> applyForFormDataList = applyForFormDataService.getApplyForFormDataByEmpId(empId);
//            return new ResponseEntity<>(applyForFormDataList, HttpStatus.OK);
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
 //   }
    
//    @GetMapping("/byTravelId/{travelId}")
//    public ResponseEntity<ApplyForFormData> getApplyForFormDataByTravelId(@PathVariable Long travelId) {
//        try {
//            Optional<ApplyForFormData> applyForFormData = applyForFormDataService.getApplyForFormDataByTravelId(travelId);
//            return applyForFormData.map(data -> new ResponseEntity<>(data, HttpStatus.OK))
//                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    @GetMapping("/byTravelId/{travelId}")
    public ResponseEntity<List<ApplyForFormData>> getApplyForFormDataByTravelId(@PathVariable Long travelId) {
        try {
            List<ApplyForFormData> applyForFormDataList = applyForFormDataService.getApplyForFormDataByTravelId(travelId);
            return new ResponseEntity<>(applyForFormDataList, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
//    @PutMapping("/update/{travelId}")
//    public ResponseEntity<ApplyForFormData> updateApplyForFormDataByTravelId(@PathVariable Long travelId, @RequestBody ApplyForFormData applyForFormData) {
//        try {
//            Optional<ApplyForFormData> existingApplyForFormData = applyForFormDataService.getApplyForFormDataByTravelId(travelId);
//            if (existingApplyForFormData.isPresent()) {
//                // Update the existing ApplyForFormData object
//                ApplyForFormData updatedApplyForFormData = applyForFormDataService.updateApplyForFormDataByTravelId(travelId, applyForFormData);
//                return new ResponseEntity<>(updatedApplyForFormData, HttpStatus.OK);
//            } else {
//                // ApplyForFormData with the given travelId not found
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (IOException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    @PutMapping("/update/{travelId}")
    public ResponseEntity<ApplyForFormData> updateApplyForFormDataByTravelId(@PathVariable Long travelId, @RequestBody ApplyForFormData updatedApplyForFormData) {
        try {
            ApplyForFormData updatedFormData = applyForFormDataService.updateApplyForFormDataByTravelId(travelId, updatedApplyForFormData);
            return new ResponseEntity<>(updatedFormData, HttpStatus.OK);
        }catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }


}

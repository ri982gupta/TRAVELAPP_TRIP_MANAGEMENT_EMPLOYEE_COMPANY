
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

import com.example.mypkg.model.HotelData;
import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.service.HotelDataService;

@RestController
@RequestMapping("/api/hotel")
public class HotelDataController {

    @Autowired
    private HotelDataService hotelDataService;

    @PostMapping("/save")
    public ResponseEntity<ResponseModel> saveHotelData(@RequestBody HotelData hotelData) {
        ResponseModel responseModel = hotelDataService.addHotelData(hotelData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseModel> getHotelData(@PathVariable Long id) {
        ResponseModel responseModel = hotelDataService.fetchHotelDataDetails(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-by-emp/{empId}")
    public ResponseEntity<ResponseModel> getHotelDataByEmpId(@PathVariable String empId) {
        ResponseModel responseModel = hotelDataService.getHotelDataByEmpId(empId);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseModel> getAllHotelData() {
        ResponseModel responseModel = hotelDataService.fetchAllHotelData();
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseModel> updateHotelData(@RequestBody HotelData hotelData) {
        ResponseModel responseModel = hotelDataService.updateHotelData(hotelData);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteHotelData(@PathVariable Long id) {
        ResponseModel responseModel = hotelDataService.deleteHotelData(id);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}

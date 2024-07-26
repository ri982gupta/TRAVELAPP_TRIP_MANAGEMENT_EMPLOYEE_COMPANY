//package com.example.mypkg.controller;
//
//
//import com.example.mypkg.model.ApplyForformData;
//import com.example.mypkg.model.CombinedDataRequest;
//import com.example.mypkg.model.FilteredData;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.io.IOException;
//
//@RestController
//public class CombinedDataController {
//
//	@PostMapping("/receiveData")
//    public String receiveData(@RequestBody CombinedDataRequest combinedDataRequest) {
//        if (combinedDataRequest == null || combinedDataRequest.getApplyForformData() == null) {
//            return "Invalid request data";
//        }
//
//        ApplyForformData applyForformData = combinedDataRequest.getApplyForformData();
//        FilteredData filteredData = combinedDataRequest.getFilteredData();
//
//        System.out.println("Received ApplyForformData: " + applyForformData);
//        if (filteredData != null) {
//            System.out.println("Received filteredData: " + filteredData);
//        }
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            objectMapper.writeValue(new File("receivedData.json"), combinedDataRequest);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "Failed to store data";
//        }
//
//        return "Data received and stored successfully";
//    }
//}

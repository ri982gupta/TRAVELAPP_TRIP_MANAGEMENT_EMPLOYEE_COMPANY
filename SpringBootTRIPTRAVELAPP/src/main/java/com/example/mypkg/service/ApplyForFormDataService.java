package com.example.mypkg.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.example.mypkg.model.ApplyForFormData;
import com.example.mypkg.model.Login;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
public class ApplyForFormDataService {

    private static final String FILE_PATH = "applyForFormData.json";
    

    private final Set<Long> uniqueTravelIds = new HashSet<>(); // Initialize uniqueTravelIds here

    public ApplyForFormDataService() {
        // Load existing travelIds from the file if needed
        try {
            List<ApplyForFormData> allData = getAllApplyForFormData();
            for (ApplyForFormData formData : allData) {
                uniqueTravelIds.add(formData.getTravelId());
            }
        } catch (IOException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }
    

    public List<ApplyForFormData> getAllApplyForFormData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            return mapper.readValue(file, new TypeReference<List<ApplyForFormData>>() {});
        }
        return new ArrayList<>();
    }

    public ApplyForFormData saveApplyForFormData(ApplyForFormData applyForFormData) throws IOException {
    	// Check if travelId is already used
        if (!uniqueTravelIds.add(applyForFormData.getTravelId())) {
            throw new RuntimeException("TravelId must be unique");
        }
        
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        List<ApplyForFormData> applyForFormDataList = getAllApplyForFormData();
        applyForFormDataList.add(applyForFormData);

        writer.writeValue(file, applyForFormDataList);
        return applyForFormData;
    }
    
//    public List<ApplyForFormData> getApplyForFormDataByEmpId(Long empId) throws IOException {
//        List<ApplyForFormData> allData = getAllApplyForFormData();
//        return allData.stream()
//                .filter(data -> data.getEmpId().equals(empId))
//                .collect(Collectors.toList());
//    }
    
//    public Optional<ApplyForFormData> getApplyForFormDataByTravelId(Long travelId) throws IOException {
//        List<ApplyForFormData> applyForFormDataList = getAllApplyForFormData();
//        return applyForFormDataList.stream()
//                .filter(data -> data.getTravelId().equals(travelId))
//                .findFirst();
//    }
    
    public List<ApplyForFormData> getApplyForFormDataByTravelId(Long travelId) throws IOException {
        List<ApplyForFormData> allApplyForFormData = getAllApplyForFormData();
        return allApplyForFormData.stream()
             //   .filter(applyForFormData -> travelId.equals(applyForFormData.getTravelId()))
        		 .filter(applyForFormData -> applyForFormData.getTravelId().equals(travelId))
                .collect(Collectors.toList());
    }
    
//    public ApplyForFormData updateApplyForFormDataByTravelId(Long travelId, ApplyForFormData updatedApplyForFormData) throws IOException {
//        List<ApplyForFormData> allApplyForFormData = getAllApplyForFormData();
//        for (ApplyForFormData applyForFormData : allApplyForFormData) {
//            if (applyForFormData.getTravelId().equals(travelId)) {
//                // Update the ApplyForFormData object
//                // Assuming ApplyForFormData has setters for its properties
//                applyForFormData.setSomeProperty(updatedApplyForFormData.getSomeProperty());
//                // Update other properties similarly
//                // Write the updated list back to the file
//                ObjectMapper mapper = new ObjectMapper();
//                ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
//                File file = new File(FILE_PATH);
//                writer.writeValue(file, allApplyForFormData);
//                return applyForFormData; // Return the updated object
//            }
//        }
//        // If ApplyForFormData with the given travelId is not found
//        throw new NotFoundException("ApplyForFormData with travelId " + travelId + " not found");
//    }
    
    public ApplyForFormData updateApplyForFormDataByTravelId(Long travelId, ApplyForFormData updatedApplyForFormData) throws IOException {
        List<ApplyForFormData> allApplyForFormData = getAllApplyForFormData();
        boolean found = false;
        
        for (ApplyForFormData applyForFormData : allApplyForFormData) {
            if (applyForFormData.getTravelId().equals(travelId)) {
                // Update the ApplyForFormData object
                applyForFormData.setDateOfTravel(updatedApplyForFormData.getDateOfTravel());
                applyForFormData.setTravelFor(updatedApplyForFormData.getTravelFor());
                applyForFormData.setProject(updatedApplyForFormData.getProject());
                applyForFormData.setBusinessUnit(updatedApplyForFormData.getBusinessUnit());
                applyForFormData.setOrganisation(updatedApplyForFormData.getOrganisation());
                applyForFormData.setTrip(updatedApplyForFormData.getTrip());
                applyForFormData.setTripDescription(updatedApplyForFormData.getTripDescription());
                applyForFormData.setLocation(updatedApplyForFormData.getLocation());
                applyForFormData.setForeignExchange(updatedApplyForFormData.getForeignExchange());
                applyForFormData.setApplyFor(updatedApplyForFormData.getApplyFor());
                applyForFormData.setOther(updatedApplyForFormData.getOther());
                applyForFormData.setApprovalStatus(updatedApplyForFormData.getApprovalStatus());
                
                found = true;
                break;
            }
        }
        
//        if (!found) {
//            throw new NotFoundException("ApplyForFormData with travelId " + travelId + " not found");
//        }
        
        // Write the updated list back to the file
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Paths.get(FILE_PATH).toFile(), allApplyForFormData);
        
        return updatedApplyForFormData;
    }

    
    
}

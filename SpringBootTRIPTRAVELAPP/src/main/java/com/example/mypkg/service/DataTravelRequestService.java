package com.example.mypkg.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.mypkg.model.DataTravelRequest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Service
//public class DataTravelRequestService {
//
//    private static final String FILE_PATH = "data_travel_requests.json";
//
//    public void saveDataTravelRequest(DataTravelRequest dataTravelRequest) {
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File(FILE_PATH);
//        try {
//            // Write the new data to the file, overwriting existing content
//            mapper.writeValue(file, dataTravelRequest);
//        } catch (IOException e) {
//            throw new RuntimeException("Error saving travel request: " + e.getMessage());
//        }
//    }
//}


import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;



@Service
public class DataTravelRequestService {

    private static final String FILE_PATH = "data_travel_requests.json";

    public void saveDataTravelRequest(DataTravelRequest dataTravelRequest) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        try {
            List<DataTravelRequest> existingRequests = new ArrayList<>();

            // Read existing data from the file if it exists
            if (file.exists() && file.length() > 0) {
                // Read the existing content from the file
                existingRequests = mapper.readValue(file, new TypeReference<List<DataTravelRequest>>() {});
            }

            // Append the new request to the existing list
            existingRequests.add(dataTravelRequest);

            // Write the updated list back to the file
            writer.writeValue(file, existingRequests);
        } catch (IOException e) {
            throw new RuntimeException("Error saving travel request: " + e.getMessage());
        }
    }
    
    public List<DataTravelRequest> getAllDataTravelRequests() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            if (file.exists() && file.length() > 0) {
                // Read existing data from the file
                return mapper.readValue(file, new TypeReference<List<DataTravelRequest>>() {});
            }
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving all travel requests: " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public DataTravelRequest getDataTravelRequestById(Long id) {
        List<DataTravelRequest> dataTravelRequests = getAllDataTravelRequests();
        for (DataTravelRequest request : dataTravelRequests) {
            if (request.getId().equals(id)) {
                return request;
            }
        }
        return null; // Return null if no matching ID is found
    }
}

//
//{"id":2,"dateOfTravel":"2024-04-01","travelFor":"Business","project":"Project X","businessUnit":"Business Unit A","organisation":"Company ABC","trip":"Business Trip","tripDescription":"Meeting with clients","location":"New York","applyFor":"John Doe","other":"N/A","foreignExchange":null}



package com.example.mypkg.service;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.mypkg.model.DataTravelRequest;
import com.example.mypkg.model.Travel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;


@Service
public class TravelService {

    private static final String FILE_PATH = "travel.json";
//
//    public void saveTravel(Travel travel) {
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File(FILE_PATH);
//        try {
//            
//            // Write the new data to the file, overwriting existing content
//            mapper.writeValue(file, travel);
//        } catch (IOException e) {
//            throw new RuntimeException("Error saving travel : " + e.getMessage());
//        }
//    }
//    
    
    public void saveTravel(Travel travel) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);
        try {
            List<Travel> existingTravels = new ArrayList<>();

            // Read existing data from the file if it exists
            if (file.exists() && file.length() > 0) {
                // Read the existing content from the file
                existingTravels = mapper.readValue(file, new TypeReference<List<Travel>>() {});
            }

            // Append the new travel data to the existing list
            existingTravels.add(travel);

            // Write the updated list back to the file
            writer.writeValue(file, existingTravels);
        } catch (IOException e) {
            throw new RuntimeException("Error saving travel: " + e.getMessage());
        }
    }
    
    public List<Travel> getAllTravel() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            if (file.exists() && file.length() > 0) {
                // Read existing data from the file
                return mapper.readValue(file, new TypeReference<List<Travel>>() {});
            }
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving all travel : " + e.getMessage());
        }
        return new ArrayList<>();
    }

    public Travel getTravelById(Long id) {
        List<Travel> travel = getAllTravel();
        for (Travel request : travel) {
            if (request.getId().equals(id)) {
                return request;
            }
        }
        return null; // Return null if no matching ID is found
    }

}

//
//{"id":null,"type":"Flight","from":"New York","to":"London","departure":"2024-04-05","checkIn":"2024-04-04","checkOut":"2024-04-07","location":"Hotel XYZ"}
//
//


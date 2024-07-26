package com.example.mypkg.service;



import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.mypkg.model.TravelDesc;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;



@Service
public class TravelDescService {

    private static final String FILE_PATH = "travel_desc.json";
    
    
    public void saveTravelDesc(TravelDesc travelDesc) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        try {
            List<TravelDesc> existingRequests = new ArrayList<>();

            // Read existing data from the file if it exists
            if (file.exists() && file.length() > 0) {
                // Read the existing content from the file
                existingRequests = mapper.readValue(file, new TypeReference<List<TravelDesc>>() {});
            }

            // Append the new request to the existing list
            existingRequests.add(travelDesc);

            // Write the updated list back to the file
            writer.writeValue(file, existingRequests);
        } catch (IOException e) {
            throw new RuntimeException("Error saving travel request: " + e.getMessage());
        }
    }

    public List<TravelDesc> getAllTravelDesc() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        try {
            if (file.exists() && file.length() > 0) {
                // Read existing data from the file
                List<TravelDesc> travelDescList = mapper.readValue(file, new TypeReference<List<TravelDesc>>() {});

                // Ensure that items list is not null for each TravelDesc object
                for (TravelDesc travelDesc : travelDescList) {
                    if (travelDesc.getItems() == null) {
                        travelDesc.setItems(new ArrayList<>());
                    }
                }
                
                return travelDescList;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error retrieving all travel desc: " + e.getMessage());
        }
        return new ArrayList<>();
    }


    public TravelDesc getTravelDescById(Long id) {
        List<TravelDesc> travelDesc = getAllTravelDesc();
        for (TravelDesc request : travelDesc) {
            if (request.getId().equals(id)) {
                return request;
            }
        }
        return null; // Return null if no matching ID is found
    }
    
    public TravelDesc getTravelDescByEmpId(Long empId) {
        List<TravelDesc> travelDesc = getAllTravelDesc();
        for (TravelDesc request : travelDesc) {
            if (request.getEmpId().equals(empId)) {
                return request;
            }
        }
        return null; // Return null if no matching ID is found
    }
}

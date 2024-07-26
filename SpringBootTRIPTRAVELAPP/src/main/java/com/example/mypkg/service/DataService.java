package com.example.mypkg.service;



import com.example.mypkg.model.ApplyForFormData;
import com.example.mypkg.model.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    private static final String FILE_PATH = "data.json";

//    public List<Data> getAllData() {
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File(DATA_FILE_PATH);
//        if (!file.exists()) {
//            return new ArrayList<>();
//        }
//        try {
//            return mapper.readValue(file, new TypeReference<List<Data>>() {});
//        } catch (IOException e) {
//            throw new RuntimeException("Error reading data from file: " + e.getMessage());
//        }
//    }

//    public Data addData(Data data) {
//        List<Data> dataList = getAllData();
//        dataList.add(data);
//        saveDataToFile(dataList);
//        return data;
//    }
//
//    private void saveDataToFile(List<Data> dataList) {
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File(DATA_FILE_PATH);
//        try {
//            mapper.writeValue(file, dataList);
//        } catch (IOException e) {
//            throw new RuntimeException("Error writing data to file: " + e.getMessage());
//        }
//    }
    
    public List<Data> getAllData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > 0) {
            return mapper.readValue(file, new TypeReference<List<Data>>() {});
        }
        return new ArrayList<>();
    }

//    public Data addData(Data data) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
//        File file = new File(FILE_PATH);
//
//        List<Data> dataList = getAllData();
//        dataList.add(data);
//        
//     // Automatically fill travelId if dateOfTravel matches departure
//        List<ApplyForFormData> applyForFormDataList = getApplyForFormDataList();
//        for (ApplyForFormData applyForFormData : applyForFormDataList) {
//            if (applyForFormData.getDateOfTravel().equals(data.getDeparture())) {
//                System.out.println("Data Departure: " + data.getDeparture());
//                System.out.println("ApplyForFormData Date of Travel: " + applyForFormData.getDateOfTravel());
//                System.out.println("TravelId fetched from ApplyForFormData: " + applyForFormData.getTravelId());
//                data.setTravelId(applyForFormData.getTravelId());
//                
//                // Print travelId after setting
//                System.out.println("TravelId set in Data: " + data.getTravelId());
//                
//                break;
//            }
//        }
//
//        
//     // Print the dataList to console
//        System.out.println("Data added:");
//        for (Data d : dataList) {
//            System.out.println(d.toString()); // Assuming Data class overrides toString() method
//        }
//
//        writer.writeValue(file, dataList);
//        return data;
//    }
//    
    
    
    public Data addData(Data data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
        File file = new File(FILE_PATH);

        // Automatically fill travelId if dateOfTravel matches departure
        List<ApplyForFormData> applyForFormDataList = getApplyForFormDataList();
        for (ApplyForFormData applyForFormData : applyForFormDataList) {
            if (applyForFormData.getDateOfTravel().equals(data.getDeparture())) {
                System.out.println("Data Departure: " + data.getDeparture());
                System.out.println("ApplyForFormData Date of Travel: " + applyForFormData.getDateOfTravel());
                System.out.println("TravelId fetched from ApplyForFormData: " + applyForFormData.getTravelId());
                data.setTravelId(applyForFormData.getTravelId());
                
                // Print travelId after setting
                System.out.println("TravelId set in Data: " + data.getTravelId());
                
                // Add data to the dataList
                List<Data> dataList = getAllData();
                dataList.add(data);

                // Print the dataList to console
                System.out.println("Data added:");
                for (Data d : dataList) {
                    System.out.println(d.toString()); // Assuming Data class overrides toString() method
                }

                // Write dataList back to the file
                writer.writeValue(file, dataList);
                
                return data; // Exit the method after adding data to JSON
            }
        }

        // If no match found or data not added to JSON
        System.out.println("No match found or data not added to JSON");
        return null;
    }

    
    private List<ApplyForFormData> getApplyForFormDataList() throws IOException {
        ApplyForFormDataService applyForFormDataService = new ApplyForFormDataService();
        return applyForFormDataService.getAllApplyForFormData();
    }

    
//    public List<Data> getDataByEmpId(Long empId) throws IOException {
//        List<Data> dataList = getAllData();
//        return dataList.stream()
//                .filter(data -> empId.equals(data.getEmpId()))
//                .collect(Collectors.toList());
//    }
}
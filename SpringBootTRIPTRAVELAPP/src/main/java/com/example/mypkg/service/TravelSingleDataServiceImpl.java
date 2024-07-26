package com.example.mypkg.service;

import com.example.mypkg.model.ResponseModel;

import com.example.mypkg.model.TravelSingleData;
import com.example.mypkg.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
public class TravelSingleDataServiceImpl implements TravelSingleDataService {

    private final String FILE_PATH = "travel_single_data.json";


    
    @Override
    public ResponseModel saveTravelData(TravelSingleData travelData) {
        ResponseModel responseModel = new ResponseModel();
        
            List<TravelSingleData> travelSingleDataList = readJsonData();
            if (travelSingleDataList == null) {
                travelSingleDataList = new ArrayList<>();
            }

            travelSingleDataList.add(travelData);
            boolean status = writeJsonData(travelSingleDataList);
            
            if(status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData("Travel data saved successfully.");
        } else {

            responseModel.setStatus(Constants.FAIL);
            responseModel.setData("Failed to save travel data.");
        }
        return responseModel;
    }

    @Override
    public ResponseModel getAllTravelData() {
        ResponseModel responseModel = new ResponseModel();
        List<TravelSingleData> travelSingleDataList = readJsonData();
        if (travelSingleDataList != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(travelSingleDataList);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData("No travel data found.");
        }
        return responseModel;
    }


    
    @Override
    public ResponseModel getTravelDataById(Long id) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelSingleData> travelSingleDataList = readJsonData();

        
        if(travelSingleDataList != null){
        	for(TravelSingleData data:travelSingleDataList) {
        		if(data.getId().equals(id)) {
        			
        		
        	
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(data);
            return responseModel;
        } 
        	}
    }
        responseModel.setStatus(Constants.FAIL);
        responseModel.setData("Travel single data not found");
        return responseModel;
    }



    
    @Override
    public ResponseModel updateTravelData(TravelSingleData travelData) {
        ResponseModel responseModel = new ResponseModel();
       
            List<TravelSingleData> travelSingleDataList = readJsonData();
            
            if (travelSingleDataList!=null) {
            	for(int i = 0; i < travelSingleDataList.size(); i++) {
            		if (travelSingleDataList.get(i).getId().equals(travelData.getId())) {
            			travelSingleDataList.set(i, travelData);
                        boolean status = writeJsonData(travelSingleDataList);
                        if (status) {
                            responseModel.setStatus(Constants.SUCCESS);
                            responseModel.setData("Travel request updated successfully");
                        } else {
                            responseModel.setStatus(Constants.FAIL);
                            responseModel.setData("Failed to update travel request");
                        }
                        return responseModel;
                    }
                }
            }
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData("Travel request not found");
            return responseModel;
        }


    
    @Override
    public ResponseModel deleteTravelData(Long id) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelSingleData> travelSingleDataList = readJsonData();

        if (travelSingleDataList != null) {
            for (int i = 0; i < travelSingleDataList.size(); i++) {
                if (travelSingleDataList.get(i).getId().equals(id)) {
                	travelSingleDataList.remove(i);
                    boolean status = writeJsonData(travelSingleDataList);
                    if (status) {
                        responseModel.setStatus(Constants.SUCCESS);
                        responseModel.setData("Travel single data deleted successfully");
                    } else {
                        responseModel.setStatus(Constants.FAIL);
                        responseModel.setData("Failed to delete travel single data");
                    }
                    return responseModel;
                }
            }
        }
        responseModel.setStatus(Constants.FAIL);
        responseModel.setData("Travel single data not found");
        return responseModel;
    }

    private List<TravelSingleData> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<TravelSingleData>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean writeJsonData(List<TravelSingleData> travelSingleDataList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(travelSingleDataList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}

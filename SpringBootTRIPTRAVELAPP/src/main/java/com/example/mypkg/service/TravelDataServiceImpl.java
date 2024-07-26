package com.example.mypkg.service;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelData;
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
public class TravelDataServiceImpl implements TravelDataService {


	
	private final String FILE_PATH = "travel_data.json";

    @Override
    public ResponseModel addTravelData(TravelData travelData) {
        ResponseModel responseModel = new ResponseModel();

        List<TravelData> travelDataList = readJsonData();
        if (travelDataList == null) {
            travelDataList = new ArrayList<>();
        }

        travelDataList.add(travelData);

        boolean status = writeJsonData(travelDataList);

        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(Constants.TRAVEL_DATA_ADDED_SUCCESSFULLY);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllTravelData() {
        ResponseModel responseModel = new ResponseModel();
        List<TravelData> travelDataList = readJsonData();

        responseModel.setStatus(Constants.SUCCESS);
        responseModel.setData(travelDataList);
        return responseModel;
    }

    @Override
    public ResponseModel fetchTravelDataDetails(Long travelDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelData> travelDataList = readJsonData();

        TravelData travelData = travelDataList.stream()
                .filter(data -> data.getId().equals(travelDataId))
                .findFirst()
                .orElse(null);

        if (travelData != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(travelData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.TRAVEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel updateTravelData(TravelData travelData) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelData> travelDataList = readJsonData();

        boolean isUpdated = travelDataList.removeIf(data -> data.getId().equals(travelData.getId()));
        if (isUpdated) {
            travelDataList.add(travelData);
            boolean status = writeJsonData(travelDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.TRAVEL_DATA_UPDATED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.TRAVEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel deleteTravelData(Long travelDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelData> travelDataList = readJsonData();

        boolean isRemoved = travelDataList.removeIf(data -> data.getId().equals(travelDataId));
        if (isRemoved) {
            boolean status = writeJsonData(travelDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.TRAVEL_DATA_DELETED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.TRAVEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    public List<TravelData> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<TravelData>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeJsonData(List<TravelData> travelDataList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(travelDataList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package com.example.mypkg.service;

import com.example.mypkg.model.HotelData;
import com.example.mypkg.model.ResponseModel;
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
public class HotelDataServiceImpl implements HotelDataService {

    private final String FILE_PATH = "hotels.json";

    @Override
    public ResponseModel addHotelData(HotelData hotelData) {
        ResponseModel responseModel = new ResponseModel();

        List<HotelData> hotelDataList = readJsonData();
        if (hotelDataList == null) {
            hotelDataList = new ArrayList<>();
        }

        hotelDataList.add(hotelData);

        boolean status = writeJsonData(hotelDataList);

        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(Constants.HOTEL_DATA_ADDED_SUCCESSFULLY);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllHotelData() {
        ResponseModel responseModel = new ResponseModel();
        List<HotelData> hotelDataList = readJsonData();

        responseModel.setStatus(Constants.SUCCESS);
        responseModel.setData(hotelDataList);
        return responseModel;
    }

    @Override
    public ResponseModel fetchHotelDataDetails(Long hotelDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<HotelData> hotelDataList = readJsonData();

        HotelData hotelData = hotelDataList.stream()
                .filter(data -> data.getId().equals(hotelDataId))
                .findFirst()
                .orElse(null);

        if (hotelData != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(hotelData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.HOTEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel updateHotelData(HotelData hotelData) {
        ResponseModel responseModel = new ResponseModel();
        List<HotelData> hotelDataList = readJsonData();

        boolean isUpdated = hotelDataList.removeIf(data -> data.getId().equals(hotelData.getId()));
        if (isUpdated) {
            hotelDataList.add(hotelData);
            boolean status = writeJsonData(hotelDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.HOTEL_DATA_UPDATED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.HOTEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel deleteHotelData(Long hotelDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<HotelData> hotelDataList = readJsonData();

        boolean isRemoved = hotelDataList.removeIf(data -> data.getId().equals(hotelDataId));
        if (isRemoved) {
            boolean status = writeJsonData(hotelDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.HOTEL_DATA_DELETED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.HOTEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }
    
    @Override
    public ResponseModel getHotelDataByEmpId(String empId) {
        ResponseModel responseModel = new ResponseModel();
        List<HotelData> hotelDataList = readJsonData();

        List<HotelData> filteredData = new ArrayList<>();
        for (HotelData hotelData : hotelDataList) {
            if (hotelData.getEmpId().equals(empId)) {
                filteredData.add(hotelData);
            }
        }

        if (!filteredData.isEmpty()) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(filteredData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.HOTEL_DATA_NOT_FOUND);
        }
        return responseModel;
    }


    public List<HotelData> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<HotelData>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeJsonData(List<HotelData> hotelDataList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(hotelDataList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

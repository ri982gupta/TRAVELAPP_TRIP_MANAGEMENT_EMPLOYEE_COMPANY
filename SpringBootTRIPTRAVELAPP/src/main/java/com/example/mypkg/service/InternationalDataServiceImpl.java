package com.example.mypkg.service;

import com.example.mypkg.model.InternationalData;
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
public class InternationalDataServiceImpl implements InternationalDataService {

    private final String FILE_PATH = "internationals.json";

    @Override
    public ResponseModel addInternationalData(InternationalData internationalData) {
        ResponseModel responseModel = new ResponseModel();

        List<InternationalData> internationalDataList = readJsonData();
        if (internationalDataList == null) {
            internationalDataList = new ArrayList<>();
        }

        internationalDataList.add(internationalData);

        boolean status = writeJsonData(internationalDataList);

        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(Constants.INTERNATIONAL_DATA_ADDED_SUCCESSFULLY);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllInternationalData() {
        ResponseModel responseModel = new ResponseModel();
        List<InternationalData> internationalDataList = readJsonData();

        responseModel.setStatus(Constants.SUCCESS);
        responseModel.setData(internationalDataList);
        return responseModel;
    }

    @Override
    public ResponseModel fetchInternationalDataDetails(Long internationalDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<InternationalData> internationalDataList = readJsonData();

        InternationalData internationalData = internationalDataList.stream()
                .filter(data -> data.getId().equals(internationalDataId))
                .findFirst()
                .orElse(null);

        if (internationalData != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(internationalData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.INTERNATIONAL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel updateInternationalData(InternationalData internationalData) {
        ResponseModel responseModel = new ResponseModel();
        List<InternationalData> internationalDataList = readJsonData();

        boolean isUpdated = internationalDataList.removeIf(data -> data.getId().equals(internationalData.getId()));
        if (isUpdated) {
            internationalDataList.add(internationalData);
            boolean status = writeJsonData(internationalDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.INTERNATIONAL_DATA_UPDATED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.INTERNATIONAL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel deleteInternationalData(Long internationalDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<InternationalData> internationalDataList = readJsonData();

        boolean isRemoved = internationalDataList.removeIf(data -> data.getId().equals(internationalDataId));
        if (isRemoved) {
            boolean status = writeJsonData(internationalDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.INTERNATIONAL_DATA_DELETED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.INTERNATIONAL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel getInternationalDataByEmpId(String empId) {
        ResponseModel responseModel = new ResponseModel();
        List<InternationalData> internationalDataList = readJsonData();

        List<InternationalData> filteredData = new ArrayList<>();
        for (InternationalData internationalData : internationalDataList) {
            if (internationalData.getEmpId().equals(empId)) {
                filteredData.add(internationalData);
            }
        }

        if (!filteredData.isEmpty()) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(filteredData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.INTERNATIONAL_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    public List<InternationalData> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<InternationalData>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeJsonData(List<InternationalData> internationalDataList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(internationalDataList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package com.example.mypkg.service;

import com.example.mypkg.model.DomesticData;
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
public class DomesticDataServiceImpl implements DomesticDataService {

    private final String FILE_PATH = "domestic.json";

    @Override
    public ResponseModel addDomesticData(DomesticData domesticData) {
        ResponseModel responseModel = new ResponseModel();

        List<DomesticData> domesticDataList = readJsonData();
        if (domesticDataList == null) {
            domesticDataList = new ArrayList<>();
        }

        domesticDataList.add(domesticData);

        boolean status = writeJsonData(domesticDataList);

        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(Constants.DOMESTIC_DATA_ADDED_SUCCESSFULLY);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllDomesticData() {
        ResponseModel responseModel = new ResponseModel();
        List<DomesticData> domesticDataList = readJsonData();

        responseModel.setStatus(Constants.SUCCESS);
        responseModel.setData(domesticDataList);
        return responseModel;
    }

    @Override
    public ResponseModel fetchDomesticDataDetails(Long domesticDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<DomesticData> domesticDataList = readJsonData();

        DomesticData domesticData = domesticDataList.stream()
                .filter(data -> data.getId().equals(domesticDataId))
                .findFirst()
                .orElse(null);

        if (domesticData != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(domesticData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.DOMESTIC_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel updateDomesticData(DomesticData domesticData) {
        ResponseModel responseModel = new ResponseModel();
        List<DomesticData> domesticDataList = readJsonData();

        boolean isUpdated = domesticDataList.removeIf(data -> data.getId().equals(domesticData.getId()));
        if (isUpdated) {
            domesticDataList.add(domesticData);
            boolean status = writeJsonData(domesticDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.DOMESTIC_DATA_UPDATED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.DOMESTIC_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    @Override
    public ResponseModel deleteDomesticData(Long domesticDataId) {
        ResponseModel responseModel = new ResponseModel();
        List<DomesticData> domesticDataList = readJsonData();

        boolean isRemoved = domesticDataList.removeIf(data -> data.getId().equals(domesticDataId));
        if (isRemoved) {
            boolean status = writeJsonData(domesticDataList);
            if (status) {
                responseModel.setStatus(Constants.SUCCESS);
                responseModel.setData(Constants.DOMESTIC_DATA_DELETED_SUCCESSFULLY);
            } else {
                responseModel.setStatus(Constants.FAIL);
                responseModel.setData(Constants.ERROR_MESSAGE);
            }
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.DOMESTIC_DATA_NOT_FOUND);
        }
        return responseModel;
    }
    
    @Override
    public ResponseModel getDomesticDataByEmpId(String empId) {
        ResponseModel responseModel = new ResponseModel();
        List<DomesticData> domesticDataList = readJsonData();

        List<DomesticData> filteredData = new ArrayList<>();
        for (DomesticData domesticData : domesticDataList) {
            if (domesticData.getEmpId().equals(empId)) {
                filteredData.add(domesticData);
            }
        }

        if (!filteredData.isEmpty()) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(filteredData);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.DOMESTIC_DATA_NOT_FOUND);
        }
        return responseModel;
    }

    public List<DomesticData> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<DomesticData>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean writeJsonData(List<DomesticData> domesticDataList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(domesticDataList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

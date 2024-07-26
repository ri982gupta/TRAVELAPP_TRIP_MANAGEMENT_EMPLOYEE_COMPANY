package com.example.mypkg.service;

import com.example.mypkg.utils.Constants;
import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelRequest;
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
public class TravelRequestServiceImpl implements TravelRequestService {

    private final String FILE_PATH = "travel_requests.json";

    @Override
    public ResponseModel addTravelRequest(TravelRequest travelRequest) {
        ResponseModel responseModel = new ResponseModel();

        List<TravelRequest> travelRequestList = readJsonData();
        if (travelRequestList == null) {
            travelRequestList = new ArrayList<>();
        }

        travelRequestList.add(travelRequest);

        boolean status = writeJsonData(travelRequestList);

        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData("Travel request created successfully");
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData("Failed to create travel request");
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllTravelRequests() {
        ResponseModel responseModel = new ResponseModel();
        List<TravelRequest> travelRequestList = readJsonData();

        if (travelRequestList != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(travelRequestList);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData("No travel requests found");
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchTravelRequestDetails(Long travelRequestId) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelRequest> travelRequestList = readJsonData();

        if (travelRequestList != null) {
            for (TravelRequest request : travelRequestList) {
                if (request.getId().equals(travelRequestId)) {
                    responseModel.setStatus(Constants.SUCCESS);
                    responseModel.setData(request);
                    return responseModel;
                }
            }
        }
        responseModel.setStatus(Constants.FAIL);
        responseModel.setData("Travel request not found");
        return responseModel;
    }

    @Override
    public ResponseModel updateTravelRequest(TravelRequest travelRequest) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelRequest> travelRequestList = readJsonData();

        if (travelRequestList != null) {
            for (int i = 0; i < travelRequestList.size(); i++) {
                if (travelRequestList.get(i).getId().equals(travelRequest.getId())) {
                    travelRequestList.set(i, travelRequest);
                    boolean status = writeJsonData(travelRequestList);
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
    public ResponseModel deleteTravelRequest(Long travelRequestId) {
        ResponseModel responseModel = new ResponseModel();
        List<TravelRequest> travelRequestList = readJsonData();

        if (travelRequestList != null) {
            for (int i = 0; i < travelRequestList.size(); i++) {
                if (travelRequestList.get(i).getId().equals(travelRequestId)) {
                    travelRequestList.remove(i);
                    boolean status = writeJsonData(travelRequestList);
                    if (status) {
                        responseModel.setStatus(Constants.SUCCESS);
                        responseModel.setData("Travel request deleted successfully");
                    } else {
                        responseModel.setStatus(Constants.FAIL);
                        responseModel.setData("Failed to delete travel request");
                    }
                    return responseModel;
                }
            }
        }
        responseModel.setStatus(Constants.FAIL);
        responseModel.setData("Travel request not found");
        return responseModel;
    }



    private List<TravelRequest> readJsonData() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<TravelRequest>>() {}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean writeJsonData(List<TravelRequest> travelRequestList) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(travelRequestList));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}


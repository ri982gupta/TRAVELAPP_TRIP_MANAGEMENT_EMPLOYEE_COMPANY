package com.example.mypkg.service;

import com.example.mypkg.model.EmployeeTravelRequest;
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
public class EmployeeTravelRequestServiceImpl implements EmployeeTravelRequestService {

    private final String FILE_PATH = "employee_travel_requests.json";

    @Override
    public ResponseModel addEmployeeTravelRequest(EmployeeTravelRequest employeeTravelRequest) {
        ResponseModel responseModel = new ResponseModel();
        List<EmployeeTravelRequest> travelRequests = readTravelRequests();
        if (travelRequests == null) {
            travelRequests = new ArrayList<>();
        }
        travelRequests.add(employeeTravelRequest);
        boolean status = writeTravelRequests(travelRequests);
        if (status) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_ADDED_SUCCESSFULLY);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchAllEmployeeTravelRequest() {
        ResponseModel responseModel = new ResponseModel();
        List<EmployeeTravelRequest> travelRequests = readTravelRequests();
        if (travelRequests != null) {
            responseModel.setStatus(Constants.SUCCESS);
            responseModel.setData(travelRequests);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel fetchEmployeeTravelRequestDetails(Long employeeTravelRequestId) {
        ResponseModel responseModel = new ResponseModel();
        List<EmployeeTravelRequest> travelRequests = readTravelRequests();
        if (travelRequests != null) {
            for (EmployeeTravelRequest request : travelRequests) {
                if (request.getId() == employeeTravelRequestId) {
                    responseModel.setStatus(Constants.SUCCESS);
                    responseModel.setData(request);
                    return responseModel;
                }
            }
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_NOT_FOUND);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel updateEmployeeTravelRequest(EmployeeTravelRequest employeeTravelRequest) {
        ResponseModel responseModel = new ResponseModel();
        List<EmployeeTravelRequest> travelRequests = readTravelRequests();
        if (travelRequests != null) {
            for (int i = 0; i < travelRequests.size(); i++) {
                EmployeeTravelRequest request = travelRequests.get(i);
                if (request.getId() == employeeTravelRequest.getId()) {
                    travelRequests.set(i, employeeTravelRequest);
                    boolean status = writeTravelRequests(travelRequests);
                    if (status) {
                        responseModel.setStatus(Constants.SUCCESS);
                        responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_UPDATED_SUCCESSFULLY);
                    } else {
                        responseModel.setStatus(Constants.FAIL);
                        responseModel.setData(Constants.ERROR_MESSAGE);
                    }
                    return responseModel;
                }
            }
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_NOT_FOUND);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel deleteEmployeeTravelRequest(Long employeeTravelRequestId) {
        ResponseModel responseModel = new ResponseModel();
        List<EmployeeTravelRequest> travelRequests = readTravelRequests();
        if (travelRequests != null) {
            for (int i = 0; i < travelRequests.size(); i++) {
                EmployeeTravelRequest request = travelRequests.get(i);
                if (request.getId() == employeeTravelRequestId) {
                    travelRequests.remove(i);
                    boolean status = writeTravelRequests(travelRequests);
                    if (status) {
                        responseModel.setStatus(Constants.SUCCESS);
                        responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_DELETED_SUCCESSFULLY);
                    } else {
                        responseModel.setStatus(Constants.FAIL);
                        responseModel.setData(Constants.ERROR_MESSAGE);
                    }
                    return responseModel;
                }
            }
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.EMPLOYEE_TRAVEL_REQUEST_NOT_FOUND);
        } else {
            responseModel.setStatus(Constants.FAIL);
            responseModel.setData(Constants.ERROR_MESSAGE);
        }
        return responseModel;
    }

    @Override
    public ResponseModel getEmployeeTravelRequestByEmpId(String employeeId) {
        
        return null;
    }

    private List<EmployeeTravelRequest> readTravelRequests() {
        try {
            String json = Files.readString(Path.of(FILE_PATH));
            return new Gson().fromJson(json, new TypeToken<List<EmployeeTravelRequest>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean writeTravelRequests(List<EmployeeTravelRequest> travelRequests) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(new Gson().toJson(travelRequests));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}



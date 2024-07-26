package com.example.mypkg.service;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelRequest;


public interface TravelRequestService {

   
    ResponseModel addTravelRequest(TravelRequest travelRequest);
    ResponseModel fetchAllTravelRequests();
    ResponseModel fetchTravelRequestDetails(Long travelRequestId);
    ResponseModel updateTravelRequest(TravelRequest travelRequest);
    ResponseModel deleteTravelRequest(Long travelRequestId);

   
//  ResponseModel getTravelRequestsByEmpId(String empId);
}
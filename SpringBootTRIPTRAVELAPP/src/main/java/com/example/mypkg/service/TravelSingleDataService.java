package com.example.mypkg.service;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelSingleData;

public interface TravelSingleDataService {
    ResponseModel saveTravelData(TravelSingleData travelData);
    ResponseModel getAllTravelData();
    ResponseModel getTravelDataById(Long id);
    ResponseModel updateTravelData( TravelSingleData travelData);
    ResponseModel deleteTravelData(Long id);
}


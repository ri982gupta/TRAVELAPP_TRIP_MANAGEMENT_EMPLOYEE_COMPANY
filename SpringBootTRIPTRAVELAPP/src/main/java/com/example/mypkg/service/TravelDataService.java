package com.example.mypkg.service;

import com.example.mypkg.model.ResponseModel;
import com.example.mypkg.model.TravelData;

public interface TravelDataService {
	
	    ResponseModel addTravelData(TravelData travelData);
	    ResponseModel fetchAllTravelData();
	    ResponseModel fetchTravelDataDetails(Long travelDataId);
	    ResponseModel updateTravelData(TravelData travelData);
	    ResponseModel deleteTravelData(Long travelDataId);
}

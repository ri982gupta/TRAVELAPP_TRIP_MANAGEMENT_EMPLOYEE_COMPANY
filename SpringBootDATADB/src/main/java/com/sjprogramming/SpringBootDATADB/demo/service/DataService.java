package com.sjprogramming.SpringBootDATADB.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.SpringBootDATADB.demo.persistence.ApplyForFormData;
import com.sjprogramming.SpringBootDATADB.demo.persistence.Data;
import com.sjprogramming.SpringBootDATADB.demo.persistence.DataRepository;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepository dataRepository;

    public List<Data> getAllDatas() {
        return dataRepository.findAll();
    }

    public Data getDataById(Long id) {
        return dataRepository.findById(id).orElse(null);
    }
    
    public Data getDataByTravelId(Long travelId) {
        return dataRepository.findById(travelId).orElse(null);
    }

//    public Data createData(Data data) {
//        return dataRepository.save(data);
//    }
    
    public Data createData(Data data) {
        // Check if dateOfTravel of ApplyForFormData matches departure of Data
        List<ApplyForFormData> applyForFormDataList = getApplyForFormDataList();
        for (ApplyForFormData applyForFormData : applyForFormDataList) {
            if (applyForFormData.getDateOfTravel().equals(data.getDeparture())) {
                // If there's a match, assign travelId from ApplyForFormData to Data
                data.setTravelId(applyForFormData.getTravelId());
                
                // Save the Data entity
                return dataRepository.save(data);
            }
        }
        
        // If no match found
        return null;
    }
    
    private List<ApplyForFormData> getApplyForFormDataList() {
        ApplyForFormDataService applyForFormDataService = new ApplyForFormDataService();
        return applyForFormDataService.getAllApplyForFormDatas();
    }

    
    public Data updateData(Long id, Data data) {
        Data existingData = dataRepository.findById(id).orElse(null);
        if (existingData != null) {
        	existingData.setId(data.getId());
            return dataRepository.save(existingData);
        }
        return null;
    }
    
    public Data updateDataByTravelId(Long travelId, Data data) {
        Data existingData = dataRepository.findById(travelId).orElse(null);
        if (existingData != null) {
        	existingData.setTravelId(data.getTravelId());
            return dataRepository.save(existingData);
        }
        return null;
    }

    public boolean deleteData(Long id) {
        Data existingData = dataRepository.findById(id).orElse(null);
        if (existingData != null) {
            dataRepository.delete(existingData);
            return true;
        }
        return false;
    }
    
    
    public boolean deleteDataByTravelId(Long travelId) {
        Data existingData = dataRepository.findById(travelId).orElse(null);
        if (existingData != null) {
            dataRepository.delete(existingData);
            return true;
        }
        return false;
    }
}





    
    
    

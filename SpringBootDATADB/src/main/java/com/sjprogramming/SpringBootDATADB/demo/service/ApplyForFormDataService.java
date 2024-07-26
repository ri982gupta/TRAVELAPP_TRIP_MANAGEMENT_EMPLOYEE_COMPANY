package com.sjprogramming.SpringBootDATADB.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.SpringBootDATADB.demo.persistence.ApplyForFormData;
import com.sjprogramming.SpringBootDATADB.demo.persistence.ApplyForFormDataRepository;

import java.util.List;

@Service
public class ApplyForFormDataService {

    @Autowired
    private ApplyForFormDataRepository applyForFormDataRepository;

    public List<ApplyForFormData> getAllApplyForFormDatas() {
        return applyForFormDataRepository.findAll();
    }

    public ApplyForFormData getApplyForFormDataById(Long id) {
        return applyForFormDataRepository.findById(id).orElse(null);
    }

    public ApplyForFormData createApplyForFormData(ApplyForFormData applyForFormData) {
        return applyForFormDataRepository.save(applyForFormData);
    }

    public ApplyForFormData updateApplyForFormData(Long id, ApplyForFormData applyForFormData) {
    	ApplyForFormData existingApplyForFormData = applyForFormDataRepository.findById(id).orElse(null);
        if (existingApplyForFormData != null) {
        	existingApplyForFormData.setId(applyForFormData.getId());
            return applyForFormDataRepository.save(existingApplyForFormData);
        }
        return null;
    }
    
    public ApplyForFormData updateApplyForFormDataByTravelId(Long travelId, ApplyForFormData applyForFormData) {
    	ApplyForFormData existingApplyForFormData = applyForFormDataRepository.findById(travelId).orElse(null);
        if (existingApplyForFormData != null) {
        	existingApplyForFormData.setTravelId(applyForFormData.getTravelId());
            return applyForFormDataRepository.save(existingApplyForFormData);
        }
        return null;
    }

    public boolean deleteApplyForFormData(Long id) {
    	ApplyForFormData existingApplyForFormData = applyForFormDataRepository.findById(id).orElse(null);
        if (existingApplyForFormData != null) {
        	applyForFormDataRepository.delete(existingApplyForFormData);
            return true;
        }
        return false;
    }
}





    
    
    

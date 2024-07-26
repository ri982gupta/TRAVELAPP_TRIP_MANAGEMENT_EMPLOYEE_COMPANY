package com.sjprogramming.SpringBootDATADB.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.SpringBootDATADB.demo.persistence.DataMultiple;
import com.sjprogramming.SpringBootDATADB.demo.persistence.DataMultipleRepository;

import java.util.List;

@Service
public class DataMultipleService {

    @Autowired
    private DataMultipleRepository dataMultipleRepository;

    public List<DataMultiple> getAllDataMultiples() {
        return dataMultipleRepository.findAll();
    }

    public DataMultiple getDataMultipleById(Long id) {
        return dataMultipleRepository.findById(id).orElse(null);
    }

    public DataMultiple createDataMultiple(DataMultiple dataMultiple) {
        return dataMultipleRepository.save(dataMultiple);
    }

    public DataMultiple updateDataMultiple(Long id, DataMultiple dataMultiple) {
    	DataMultiple existingDataMultiple = dataMultipleRepository.findById(id).orElse(null);
        if (existingDataMultiple != null) {
        	existingDataMultiple.setId(dataMultiple.getId());
            return dataMultipleRepository.save(existingDataMultiple);
        }
        return null;
    }

    public boolean deleteDataMultiple(Long id) {
    	DataMultiple existingDataMultiple = dataMultipleRepository.findById(id).orElse(null);
        if (existingDataMultiple != null) {
        	dataMultipleRepository.delete(existingDataMultiple);
            return true;
        }
        return false;
    }
}





    
    
    

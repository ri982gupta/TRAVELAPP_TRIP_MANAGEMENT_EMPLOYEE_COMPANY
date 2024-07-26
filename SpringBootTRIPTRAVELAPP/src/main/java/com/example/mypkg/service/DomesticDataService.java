package com.example.mypkg.service;

import com.example.mypkg.model.DomesticData;
import com.example.mypkg.model.ResponseModel;

public interface DomesticDataService {

    ResponseModel addDomesticData(DomesticData domesticData);

    ResponseModel fetchAllDomesticData();

    ResponseModel fetchDomesticDataDetails(Long domesticDataId);

    ResponseModel updateDomesticData(DomesticData domesticData);

    ResponseModel deleteDomesticData(Long domesticDataId);
    
    ResponseModel getDomesticDataByEmpId(String empId);
}

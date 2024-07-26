package com.example.mypkg.service;

import com.example.mypkg.model.InternationalData;
import com.example.mypkg.model.ResponseModel;

public interface InternationalDataService {

    ResponseModel addInternationalData(InternationalData internationalData);

    ResponseModel fetchAllInternationalData();

    ResponseModel fetchInternationalDataDetails(Long internationalDataId);

    ResponseModel updateInternationalData(InternationalData internationalData);

    ResponseModel deleteInternationalData(Long internationalDataId);

    ResponseModel getInternationalDataByEmpId(String empId);
}

package com.example.mypkg.service;

import com.example.mypkg.model.EmployeeTravelRequest;
import com.example.mypkg.model.ResponseModel;

public interface EmployeeTravelRequestService {
    
    ResponseModel addEmployeeTravelRequest(EmployeeTravelRequest employeeTravelRequest);

    ResponseModel fetchAllEmployeeTravelRequest();

    ResponseModel fetchEmployeeTravelRequestDetails(Long employeeTravelRequestId);

    ResponseModel updateEmployeeTravelRequest(EmployeeTravelRequest employeeTravelRequest);

    ResponseModel deleteEmployeeTravelRequest(Long employeeTravelRequest);
    
    ResponseModel getEmployeeTravelRequestByEmpId(String employeeTravelRequest);
}

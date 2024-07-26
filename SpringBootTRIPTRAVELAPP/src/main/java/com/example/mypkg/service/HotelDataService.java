
package com.example.mypkg.service;

import com.example.mypkg.model.HotelData;
import com.example.mypkg.model.ResponseModel;

public interface HotelDataService {
    ResponseModel addHotelData(HotelData hotelData);
    ResponseModel fetchAllHotelData();
    ResponseModel fetchHotelDataDetails(Long hotelDataId);
    ResponseModel updateHotelData(HotelData hotelData);
    ResponseModel deleteHotelData(Long hotelDataId);
    ResponseModel getHotelDataByEmpId(String empId);
}

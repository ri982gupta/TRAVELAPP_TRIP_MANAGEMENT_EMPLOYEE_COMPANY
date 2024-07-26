package com.sjprogramming.SpringBootDATADB.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.SpringBootDATADB.demo.persistence.Data;
import com.sjprogramming.SpringBootDATADB.demo.service.DataService;

@RestController
@RequestMapping("/api/data")
public class DataResource {

    @Autowired
    private DataService dataService;

    @GetMapping
    public List<Data> getAllDatas() {
        return dataService.getAllDatas();
    }

    @GetMapping("/{id}")
    public Data getDataById(@PathVariable Long id) {
        return dataService.getDataById(id);
    }
    
    @GetMapping("/travelId/{travelId}")
    public Data getDataByTravelId(@PathVariable Long travelId) {
        return dataService.getDataByTravelId(travelId);
    }

    @PostMapping
    public Data createData(@RequestBody Data data) {
        return dataService.createData(data);
    }
    
    @PutMapping("/{id}")
    public Data updateData(@PathVariable Long id, @RequestBody Data data) {
        return dataService.updateData(id, data);
    }
    
    @PutMapping("/travelId/{id}")
    public Data updateDataByTravelId(@PathVariable Long travelId, @RequestBody Data data) {
        return dataService.updateDataByTravelId(travelId, data);
    }

    @DeleteMapping("/{id}")
    public boolean deleteData(@PathVariable Long id) {
        return dataService.deleteData(id);
    }
    
    @DeleteMapping("/travelId/{travelId}")
    public boolean deleteDataByTravelId(@PathVariable Long travelId) {
        return dataService.deleteDataByTravelId(travelId);
    }
}

package com.sjprogramming.SpringBootDATADB.demo.resource;

import com.sjprogramming.SpringBootDATADB.demo.persistence.ApplyForFormData;
import com.sjprogramming.SpringBootDATADB.demo.service.ApplyForFormDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applyForFormData")
public class ApplyForFormDataResource {

    @Autowired
    private ApplyForFormDataService applyForFormDataService;

    @GetMapping
    public List<ApplyForFormData> getAllApplyForFormDatas() {
        return applyForFormDataService.getAllApplyForFormDatas();
    }

    @GetMapping("/{id}")
    public ApplyForFormData getApplyForFormDataById(@PathVariable Long id) {
        return applyForFormDataService.getApplyForFormDataById(id);
    }

    @PostMapping
    public ApplyForFormData createApplyForFormData(@RequestBody ApplyForFormData applyForFormData) {
        return applyForFormDataService.createApplyForFormData(applyForFormData);
    }

    @PutMapping("/{id}")
    public ApplyForFormData updateApplyForFormData(@PathVariable Long id, @RequestBody ApplyForFormData applyForFormData) {
        return applyForFormDataService.updateApplyForFormData(id, applyForFormData);
    }
    
    @PutMapping("/update/{travelId}")
    public ApplyForFormData updateApplyForFormDataByTravelId(@PathVariable Long travelId, @RequestBody ApplyForFormData applyForFormData) {
        return applyForFormDataService.updateApplyForFormDataByTravelId(travelId, applyForFormData);
    }

    @DeleteMapping("/{id}")
    public boolean deleteApplyForFormData(@PathVariable Long id) {
        return applyForFormDataService.deleteApplyForFormData(id);
    }
}

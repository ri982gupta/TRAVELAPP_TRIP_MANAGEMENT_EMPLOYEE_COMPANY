package com.sjprogramming.SpringBootDATADB.demo.resource;

import com.sjprogramming.SpringBootDATADB.demo.persistence.DataMultiple;
import com.sjprogramming.SpringBootDATADB.demo.service.DataMultipleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dataMultiple")
public class DataMultipleResource {

    @Autowired
    private DataMultipleService dataMultipleService;

    @GetMapping
    public List<DataMultiple> getAllDataMultiples() {
        return dataMultipleService.getAllDataMultiples();
    }

    @GetMapping("/{id}")
    public DataMultiple getDataMultipleById(@PathVariable Long id) {
        return dataMultipleService.getDataMultipleById(id);
    }

    @PostMapping
    public DataMultiple createDataMultiple(@RequestBody DataMultiple dataMultiple) {
        return dataMultipleService.createDataMultiple(dataMultiple);
    }

    @PutMapping("/{id}")
    public DataMultiple updateDataMultiple(@PathVariable Long id, @RequestBody DataMultiple dataMultiple) {
        return dataMultipleService.updateDataMultiple(id, dataMultiple);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDataMultiple(@PathVariable Long id) {
        return dataMultipleService.deleteDataMultiple(id);
    }
}

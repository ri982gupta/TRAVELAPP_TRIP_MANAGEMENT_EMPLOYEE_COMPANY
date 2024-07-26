package com.example.mypkg.controller;

import com.example.mypkg.model.Trip;
import com.example.mypkg.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/trips")
public class TripController {
	
	private static final Logger logger = LoggerFactory.getLogger(TripController.class);

    @Autowired
    private TripService tripService;

    // POST endpoint to save a trip
    @PostMapping("/save")
    public void saveTrip(@RequestBody Trip trip) {
    	logger.info("Received trip: {}", trip);
        tripService.saveTrip(trip);
    }

    // GET endpoint to retrieve all trips
    @GetMapping("/all")
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    // GET endpoint to retrieve a trip by ID
    @GetMapping("/id/{id}")
    public Trip getTripById(@PathVariable int id) {
        return tripService.getTripById(id);
    }
    
 // GET endpoint to retrieve a trip by empID
    @GetMapping("/empId/{empId}")
    public Trip getTripByEmpId(@PathVariable Long empId) {
        return tripService.getTripByEmpId(empId);
    }
}

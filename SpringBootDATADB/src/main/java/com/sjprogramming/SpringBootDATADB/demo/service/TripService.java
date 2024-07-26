package com.sjprogramming.SpringBootDATADB.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.SpringBootDATADB.demo.persistence.Trip;
import com.sjprogramming.SpringBootDATADB.demo.persistence.TripRepository;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long id, Trip trip) {
    	Trip existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip != null) {
        	existingTrip.setId(trip.getId());
            return tripRepository.save(existingTrip);
        }
        return null;
    }

    public boolean deleteTrip(Long id) {
    	Trip existingTrip = tripRepository.findById(id).orElse(null);
        if (existingTrip!= null) {
        	tripRepository.delete(existingTrip);
            return true;
        }
        return false;
    }
}





    
    
    

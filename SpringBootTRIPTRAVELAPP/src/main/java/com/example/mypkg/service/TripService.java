package com.example.mypkg.service;
//
//import com.example.mypkg.model.Trip;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class TripService {
//
//    private final String JSON_FILE_PATH = "trips.json";
//
//    // Method to save trip to JSON file
////    public void saveTrip(Trip trip) {
////        ObjectMapper mapper = new ObjectMapper();
////        try {
////            List<Trip> existingTrips = getAllTrips();
////            if (existingTrips == null) {
////                existingTrips = new ArrayList<>();
////            }
////            existingTrips.add(trip);
////            mapper.writeValue(new File(JSON_FILE_PATH), existingTrips);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//    
// // Method to save trip to JSON file
//    public void saveTrip(Trip trip) {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            List<Trip> existingTrips = getAllTrips();
//            if (existingTrips == null) {
//                existingTrips = new ArrayList<>();
//            }
//            existingTrips.add(trip);
//            mapper.writeValue(new File(JSON_FILE_PATH), existingTrips);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    // Method to retrieve all trips from JSON file
//    public List<Trip> getAllTrips() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Trip[] trips = mapper.readValue(new File(JSON_FILE_PATH), Trip[].class);
//            if (trips != null) {
//                return Arrays.asList(trips);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    
// // Method to retrieve all trips from JSON file
////    public List<Trip> getAllTrips() {
////        ObjectMapper mapper = new ObjectMapper();
////        try {
////            Trip[] trips = mapper.readValue(new File(JSON_FILE_PATH), Trip[].class);
////            if (trips != null) {
////                return new ArrayList<>(Arrays.asList(trips)); // Convert to modifiable list
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return new ArrayList<>(); // Return an empty list if file does not exist or cannot be read
////    }
//
//
//    // Method to retrieve a trip by ID from JSON file
//    public Trip getTripById(int id) {
//        List<Trip> trips = getAllTrips();
//        if (trips != null) {
//            for (Trip trip : trips) {
//                if (trip.getId() == id) {
//                    return trip;
//                }
//            }
//        }
//        return null;
//    }
//}

import com.example.mypkg.model.Trip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TripService {

    private final String JSON_FILE_PATH = "trips.json";
    private static final Logger logger = LoggerFactory.getLogger(TripService.class);

    // Method to save trip to JSON file
    public void saveTrip(Trip trip) {
    	
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Trip> existingTrips = getAllTrips();
            if (existingTrips == null) {
                existingTrips = new ArrayList<>();
            }
            existingTrips.add(trip);
            mapper.writeValue(new File(JSON_FILE_PATH), existingTrips);
            logger.info("Trip saved successfully: {}", trip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
 // Method to retrieve all trips from JSON file
    public List<Trip> getAllTrips() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File file = new File(JSON_FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            Trip[] trips = mapper.readValue(file, Trip[].class);
            return new ArrayList<>(Arrays.asList(trips));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    // Method to retrieve a trip by ID from JSON file
    public Trip getTripById(int id) {
        List<Trip> trips = getAllTrips();
        if (trips != null) {
            for (Trip trip : trips) {
                if (trip.getId() == id) {
                    return trip;
                }
            }
        }
        return null;
    }
    
    
 // Method to retrieve a trip by emp ID from JSON file
    public Trip getTripByEmpId(Long empId) {
        List<Trip> trips = getAllTrips();
        if (trips != null) {
            for (Trip trip : trips) {
                if (trip.getEmpId().equals(empId)) {
                    return trip;
                }
            }
        }
        return null;
    }
}


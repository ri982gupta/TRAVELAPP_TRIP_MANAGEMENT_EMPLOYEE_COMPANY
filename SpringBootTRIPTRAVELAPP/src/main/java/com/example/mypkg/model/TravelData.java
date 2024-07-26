package com.example.mypkg.model;

import java.util.List;

//@Entity
//@Table(name = "TravelData")
public class TravelData {
	
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
    private Long id;
    
  //@Column(name = "type")
    private List<String> type;
    
  //@Column(name = "location")
    private List<String> location;
    
  //@Column(name = "from_location")
    private List<String> from;
    
  //@Column(name = "to_location")
    private List<String> to;
    
  //@Column(name = "check_in")
    private List<String> checkIn;
    
  //@Column(name = "check_out")
    private List<String> checkOut;
    
  //@Column(name = "departure")
    private List<String> departure;

    public TravelData() {}

    public TravelData(Long id, List<String> type, List<String> location, List<String> from, List<String> to, List<String> checkIn, List<String> checkOut, List<String> departure) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.from = from;
        this.to = to;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.departure = departure;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public List<String> getFrom() {
        return from;
    }

    public void setFrom(List<String> from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public List<String> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(List<String> checkIn) {
        this.checkIn = checkIn;
    }

    public List<String> getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(List<String> checkOut) {
        this.checkOut = checkOut;
    }

    public List<String> getDeparture() {
        return departure;
    }

    public void setDeparture(List<String> departure) {
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "TravelData{" +
                "id=" + id +
                ", type=" + type +
                ", location=" + location +
                ", from=" + from +
                ", to=" + to +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", departure=" + departure +
                '}';
    }
}


//
//CREATE TABLE TravelData (
//    id INT PRIMARY KEY IDENTITY,
//    type VARCHAR(255),
//    location VARCHAR(255),
//    from_location VARCHAR(255),
//    to_location VARCHAR(255),
//    check_in DATE,
//    check_out DATE,
//    departure DATE
//);


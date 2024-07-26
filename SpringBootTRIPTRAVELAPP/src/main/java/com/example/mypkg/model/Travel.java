package com.example.mypkg.model;


//import javax.persistence.*;

//@Entity
//@Table(name = "Travel")
public class Travel {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "type")
    private String type;

    //@Column(name = "from_location")
    private String from;

    //@Column(name = "to_location")
    private String to;

    //@Column(name = "departure")
    private String departure;

    //@Column(name = "check_in")
    private String checkIn;

    //@Column(name = "check_out")
    private String checkOut;

    //@Column(name = "location")
    private String location;

    //@Column(name = "emp_id")
//    private Long empId;

    public Travel() {
    }

    public Travel(Long id, String type, String from, String to, String departure, String checkIn, String checkOut, String location) {
    	this.id = id;
        this.type = type;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.location = location;
//        this.empId = empId;
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
    
    public String getCheckIn() {
    	return checkIn;
    }
    
    public void setCheckIn(String checkIn) {
    	this.checkIn = checkIn;
    }
    
    public String getCheckOut() {
    	return checkOut;
    }
    
    public void setCheckOut(String checkOut) {
    	this.checkOut = checkOut;
    }
    
    public String getLocation() {
    	return location;
    }
    
    public void setLocation(String location) {
    	this.location = location;
    }
    
//    public Long getEmpId() {
//    	return id;
//    }
//    
//    public void setEmpId(Long empId) {
//    	this.empId = empId;
//    }
}

//CREATE TABLE Travel (
//	    id INT IDENTITY PRIMARY KEY,
//	    type VARCHAR(255),
//	    from_location VARCHAR(255),
//	    to_location VARCHAR(255),
//	    departure DATE,
//	    check_in DATE,
//	    check_out DATE,
//	    location VARCHAR(255),
//	    emp_id INT,
//	    FOREIGN KEY (emp_id) REFERENCES DataTravelRequest(empId)
//	);


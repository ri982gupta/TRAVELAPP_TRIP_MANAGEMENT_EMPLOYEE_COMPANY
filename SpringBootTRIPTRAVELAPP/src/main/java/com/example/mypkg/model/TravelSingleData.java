package com.example.mypkg.model;



//@Entity
//@Table(name = "TravelSingleData")
public class TravelSingleData {
	
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
    private Long id;
    
  //@Column(name = "type")
    private String type;
    
  //@Column(name = "location")
    private String location;
    
  //@Column(name = "from_location")
    private String from;
    
  //@Column(name = "to_location")
    private String to;
    
  //@Column(name = "check_in")
    private String checkIn;
    
  //@Column(name = "check_out")
    private String checkOut;
    
  //@Column(name = "departure")
    private String departure;

    // Constructors
    public TravelSingleData() {
    }

    public TravelSingleData(Long id, String type, String location, String from, String to, String checkIn, String checkOut, String departure) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}



//CREATE TABLE TravelSingleData (
//	    id INT PRIMARY KEY AUTO_INCREMENT,
//	    type VARCHAR(255),
//	    location VARCHAR(255),
//	    from_location VARCHAR(255),
//	    to_location VARCHAR(255),
//	    check_in DATE,
//	    check_out DATE,
//	    departure DATE
//	);


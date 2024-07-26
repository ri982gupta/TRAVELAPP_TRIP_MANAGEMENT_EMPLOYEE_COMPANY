package com.example.mypkg.model;


//@Entity
//@Table(name = "Data")
public class Data {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(name = "type")
    private String type;
    
    //@Column(name = "location")
    private String location;
    
    //@Column(name = "from_loc")
    private String from;
    
    //@Column(name = "to_loc")
    private String to;
    
    //@Column(name = "checkIn")
    private String checkIn;
    
    //@Column(name = "checkOut")
    private String checkOut;
    
    //@Column(name = "departure")
    private String departure;
    
    //private Long empId;
    
    //@Column(name = "travelId")
    private Long travelId;                         //added extra

    // Constructors, getters, and setters
    
   
    
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
	
//	public Long getEmpId() {
//		return empId;
//	}
//	public void setEmpId(Long empId) {
//		this.empId = empId;
//	}
	
	public Long getTravelId() {
		return travelId;
	}

	public void setTravelId(Long travelId) {
		this.travelId = travelId;
	}

	public Data(Long id, String type, String location, String from, String to, String checkIn, String checkOut,
			String departure, Long travelId) {
		super();
		this.id = id;
		this.type = type;
		this.location = location;
		this.from = from;
		this.to = to;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.departure = departure;
		//this.empId = empId;
		this.travelId = travelId;
		}
    
    public Data() {
    	
    }
}
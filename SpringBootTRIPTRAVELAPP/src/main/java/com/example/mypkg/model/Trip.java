package com.example.mypkg.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//
//@Entity
//@Table(name = "trip")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trip {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
	private int id;
	
	// @Column(name = "dateOfTravel")
	private String dateOfTravel;
	
	//@Column(name = "travelFor")
    private String travelFor;
    
    // @Column(name = "project")
    private String project;
    
    //@Column(name = "businessUnit")
    private String businessUnit;
    
    // @Column(name = "organisation")
    private String organisation;
    
    //@Column(name = "trip")
    private String trip;
    
    // @Column(name = "tripDescription")
    private String tripDescription;
    
    //@Column(name = "location")
    private String location;
    
    //@Column(name = "foreignExchange")
    private String foreignExchange;
    
    // @Column(name = "applyFor")
    private String applyFor;
    
    // @Column(name = "other")
    private String other;
    
    // @Column(name = "empId")
    private Long empId;
    
    @JsonProperty("triptravelDetails")
    private List<TripTravelDetails> triptravelDetails;
    
    public Trip() {
       
    }

    
	public Trip(int id, String dateOfTravel, String travelFor, String project, String businessUnit, String organisation,
			String trip, String tripDescription, String location, String foreignExchange, String applyFor, String other, Long empId,
			List<TripTravelDetails> triptravelDetails) {
		super();
		this.id = id;
		this.dateOfTravel = dateOfTravel;
		this.travelFor = travelFor;
		this.project = project;
		this.businessUnit = businessUnit;
		this.organisation = organisation;
		this.trip = trip;
		this.tripDescription = tripDescription;
		this.location = location;
		this.foreignExchange = foreignExchange;
		this.applyFor = applyFor;
		this.other = other;
		this.triptravelDetails = triptravelDetails;
        this.empId = empId;
	}
	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
	public String getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public String getTravelFor() {
		return travelFor;
	}
	public void setTravelFor(String travelFor) {
		this.travelFor = travelFor;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	public String getTripDescription() {
		return tripDescription;
	}
	public void setTripDescription(String tripDescription) {
		this.tripDescription = tripDescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getForeignExchange() {
		return foreignExchange;
	}
	public void setForeignExchange(String foreignExchange) {
		this.foreignExchange = foreignExchange;
	}
	public String getApplyFor() {
		return applyFor;
	}
	public void setApplyFor(String applyFor) {
		this.applyFor = applyFor;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
    public Long getEmpId() {
	    return empId;
    }

    public void setEmpId(Long empId) {
	    this.empId = empId;
    }
	
//public List<TripTravelDetails> getTripTravelDetails() {
//		return triptravelDetails;
//	}
	public void setTravelDetails(List<TripTravelDetails> triptravelDetails) {
		this.triptravelDetails = triptravelDetails;
	}   
}


//@Entity
//@Table(name = "trip_travel_details")
//@JsonIgnoreProperties(ignoreUnknown = true)
class TripTravelDetails {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
        private int id;
        
        //@ManyToOne
        //@JoinColumn(name = "empId")
        //@JsonIgnoreProperties("triptravelDetails")
        //private Trip trip;
        
        // @Column(name = "empId")
    //  private Long empId;
        
        // @Column(name = "type")
	    private String type;
	    
	    // @Column(name = "location")
	    private String location;
	    
	    // @Column(name = "fromCity")
	    private String from;
	    
	    //@Column(name = "toCity")
	    private String to;
	    
	    // @Column(name = "checkIn")
	    private String checkIn;
	    
	    //@Column(name = "checkOut")
	    private String checkOut;
	    
	    //@Column(name = "departure")
	    private String departure;
	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	//  public Long getEmpId() {
//		return id;
	//}
	//
	//public void setEmpId(Long empId) {
//		this.empId = empId;
	//}

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
		
		public TripTravelDetails() {
			
		}

		public TripTravelDetails(int id, String type, String location, String from, String to, String checkIn,
				String checkOut, String departure) {
			super();
			this.id = id;
//	      this.empId = empId;
			this.type = type;
			this.location = location;
			this.from = from;
			this.to = to;
			this.checkIn = checkIn;
			this.checkOut = checkOut;
			this.departure = departure;
		}
}


//CREATE TABLE trip (
//	    id INT IDENTITY PRIMARY KEY,
//	    dateOfTravel DATE,
//	    travelFor VARCHAR(50),
//	    project VARCHAR(50),
//	    businessUnit VARCHAR(50),
//	    organisation VARCHAR(50),
//	    trip VARCHAR(50),
//	    tripDescription TEXT,
//	    location VARCHAR(50),
//	    foreignExchange VARCHAR(50),
//	    applyFor VARCHAR(50),
//	    other VARCHAR(50),
//		// empId VARCHAR(50)
//	);
//
//	CREATE TABLE trip_travel_details (
//	    id INT IDENTITY PRIMARY KEY,
//	    empId INT,
//	    type VARCHAR(50),
//	    location VARCHAR(50),
//	    fromCity VARCHAR(50),
//	    toCity VARCHAR(50),
//	    checkIn DATE,
//	    checkOut DATE,
//	    departure DATE,
//	    FOREIGN KEY (empId) REFERENCES trip(empId)
//	);
//

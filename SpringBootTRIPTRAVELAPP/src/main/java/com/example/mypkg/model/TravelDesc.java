package com.example.mypkg.model;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.*;

//@Entity
//@Table(name = "travel_desc")

public class TravelDesc {
	
//	@OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "travel_desc_id", referencedColumnName = "id")
	private List<Item> items;
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 //@Column(name = "id")
	private Long id;
	
	 //@Column(name = "apply_for")
    private String applyFor;
    
    //@Column(name = "business_unit")
    private String businessUnit;
    
    //@Column(name = "date_of_travel")
    private String dateOfTravel;
    
    //@Column(name = "foreign_exchange")
    private String foreignExchange;
    
    //@Column(name = "location")
    private String location;
    
    //@Column(name = "organisation")
    private String organisation;
    
    //@Column(name = "other")
    private String other;
    
    //@Column(name = "project")
    private String project;
    
    //@Column(name = "travel_for")
    private String travelFor;
    
    //@Column(name = "trip")
    private String trip;
    
    //@Column(name = "trip_description")
    private String tripDescription;
  //@Column(name = "empId")
    private Long empId;
    
    public TravelDesc() {
    	 this.items = new ArrayList<>();
    }

    public TravelDesc(List<Item> items,Long id, String applyFor, String businessUnit, String dateOfTravel,
			String foreignExchange, String location, String organisation, String other, String project,
			String travelFor, String trip, String tripDescription, Long empId) {
//		super();
		this.items = items;
		this.id = id;
		this.applyFor = applyFor;
		this.businessUnit = businessUnit;
		this.dateOfTravel = dateOfTravel;
		this.foreignExchange = foreignExchange;
		this.location = location;
		this.organisation = organisation;
		this.other = other;
		this.project = project;
		this.travelFor = travelFor;
		this.trip = trip;
		this.tripDescription = tripDescription;
		this.empId = empId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApplyFor() {
		return applyFor;
	}
	public void setApplyFor(String applyFor) {
		this.applyFor = applyFor;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public String getForeignExchange() {
		return foreignExchange;
	}
	public void setForeignExchange(String foreignExchange) {
		this.foreignExchange = foreignExchange;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getTravelFor() {
		return travelFor;
	}
	public void setTravelFor(String travelFor) {
		this.travelFor = travelFor;
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
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
    
}


//@Entity
//@Table(name = "item")
class Item {
	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@ManyToOne
//    @JoinColumn(name = "travel_desc_id")
//    private TravelDesc travelDesc;
	
	 //@Column(name = "type")
    private String type;
    
    //@Column(name = "from_location")
    private String from;
    
    //@Column(name = "to_location")
    private String to;
    
    //@Column(name = "departure")
    private String departure;
    
    //@Column(name = "checkIn")
    private String checkIn;
    
    //@Column(name = "checkOut")
    private String checkOut;
    
    //@Column(name = "location")
    private String location;

    
	
	public Item() {
		
	}
    public Item(int id, String type, String from, String to, String departure, String checkIn, String checkOut,
			String location) {
		super();
		this.id = id;
		this.type = type;
		this.from = from;
		this.to = to;
		this.departure = departure;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
}



//CREATE TABLE travel_desc (
//	    id BIGINT IDENTITY PRIMARY KEY,
//	    apply_for VARCHAR(255),
//	    business_unit VARCHAR(255),
//	    date_of_travel VARCHAR(255),
//	    foreign_exchange VARCHAR(255),
//	    location VARCHAR(255),
//	    organisation VARCHAR(255),
//	    other VARCHAR(255),
//	    project VARCHAR(255),
//	    travel_for VARCHAR(255),
//	    trip VARCHAR(255),
//	    trip_description VARCHAR(255),
//	    emp_id BIGINT
//	);
//
//	CREATE TABLE item (
//	    id BIGINT IDENTITY PRIMARY KEY,
//	    type VARCHAR(255),
//	    from_location VARCHAR(255),
//	    to_location VARCHAR(255),
//	    departure VARCHAR(255),
//	    check_in VARCHAR(255),
//	    check_out VARCHAR(255),
//	    location VARCHAR(255),
//	    travel_desc_id BIGINT,
//	    FOREIGN KEY (travel_desc_id) REFERENCES travel_desc(id)
//	);


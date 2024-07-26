package com.example.mypkg.model;

public class FormData {
	private Long id;
	private Long travelId;
    private String dateOfTravel;
    private String travelFor;
    private String project;
    private String businessUnit;
    private String organisation;
    private String trip;
    private String tripDescription;
    private String travel;
    private String foreignExchange;
    private String applyFor;
    private String other;
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
   
    
    
    public FormData() {
    	
    }
    
    public FormData(Long id, Long travelId, String dateOfTravel, String travelFor, String project, String businessUnit,
			String organisation, String trip, String tripDescription, String travel, String foreignExchange,
			String applyFor, String other, String type, String location, String from, String to, String checkIn,
			String checkOut, String departure) {
		super();
		this.id = id;
		this.travelId = travelId;
		this.dateOfTravel = dateOfTravel;
		this.travelFor = travelFor;
		this.project = project;
		this.businessUnit = businessUnit;
		this.organisation = organisation;
		this.trip = trip;
		this.tripDescription = tripDescription;
		this.travel = travel;
		this.foreignExchange = foreignExchange;
		this.applyFor = applyFor;
		this.other = other;
		this.type = type;
		this.location = location;
		this.from = from;
		this.to = to;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.departure = departure;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTravelId() {
		return travelId;
	}

	public void setTravelId(Long travelId) {
		this.travelId = travelId;
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

	public String getTravel() {
		return travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
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

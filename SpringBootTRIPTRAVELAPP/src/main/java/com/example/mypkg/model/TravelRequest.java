package com.example.mypkg.model;


//@Entity
//@Table(name = "TravelRequest")
public class TravelRequest {
	
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
    private Long id;
    
  //@Column(name = "dateOfTravel")
    private String dateOfTravel;
    
  //@Column(name = "travelFor")
    private String travelFor;
    
  //@Column(name = "project")
    private String project;
    
  //@Column(name = "businessUnit")
    private String businessUnit;
    
  //@Column(name = "organisation")
    private String organisation;
    
  //@Column(name = "trip")
    private String trip;
    
  //@Column(name = "tripDescription")
    private String tripDescription;
    
  //@Column(name = "location")
    private String location;
    
  //@Column(name = "applyFor")
    private String applyFor;
    
  //@Column(name = "other")
    private String other;

    public TravelRequest() {}

 

    public TravelRequest(Long id, String dateOfTravel, String travelFor, String project, String businessUnit, String organisation, String trip, String tripDescription, String location, String applyFor, String other) {
        this.id = id;
        this.dateOfTravel = dateOfTravel;
        this.travelFor = travelFor;
        this.project = project;
        this.businessUnit = businessUnit;
        this.organisation = organisation;
        this.trip = trip;
        this.tripDescription = tripDescription;
        this.location = location;
        this.applyFor = applyFor;
        this.other = other;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}


//CREATE TABLE TravelRequest (
//	    id INT PRIMARY KEY ,
//	    dateOfTravel DATE,
//	    travelFor VARCHAR(255),
//	    project VARCHAR(255),
//	    businessUnit VARCHAR(255),
//	    organisation VARCHAR(255),
//	    trip VARCHAR(255),
//	    tripDescription TEXT,
//	    location VARCHAR(255),
//	    applyFor VARCHAR(255),
//	    other TEXT
//	);

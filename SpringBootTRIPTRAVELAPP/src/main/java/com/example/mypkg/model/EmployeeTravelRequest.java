package com.example.mypkg.model;

//import javax.persistence.*;
import java.util.List;

//@Entity
//@Table(name = "EmployeeTravelRequest")
public class EmployeeTravelRequest {
//	@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
	private Long id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "common_data_id", referencedColumnName = "id")
    private CommonTravelData commonData;
    
//  @OneToMany(mappedBy = "employeeTravelRequest", cascade = CascadeType.ALL)
    private List<TravelMultipleData> travelDataList;

    public EmployeeTravelRequest() {
    }

    public EmployeeTravelRequest(Long id, CommonTravelData commonData, List<TravelMultipleData> travelDataList) {
        this.id = id;
        this.commonData = commonData;
        this.travelDataList = travelDataList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public CommonTravelData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonTravelData commonData) {
        this.commonData = commonData;
    }

    public List<TravelMultipleData> getTravelDataList() {
        return travelDataList;
    }

    public void setTravelDataList(List<TravelMultipleData> travelDataList) {
        this.travelDataList = travelDataList;
    }
}

//@Entity
//@Table(name = "CommonTravelData")
class CommonTravelData {
	
//	@Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
//  private Long id;
	
//	@Column(name = "dateOfTravel")
    private String dateOfTravel;
    
//  @Column(name = "travelFor")
    private String travelFor;
    
//  @Column(name = "project")
    private String project;
    
//  @Column(name = "businessUnit")
    private String businessUnit;
    
//  @Column(name = "organisation")
    private String organisation;
    
//  @Column(name = "trip")
    private String trip;
    
//  @Column(name = "tripDescription")
    private String tripDescription;
    
//  @Column(name = "location")
    private String location;
    
//  @Column(name = "foreignExchange")
    private String foreignExchange;
    
//  @Column(name = "applyFor")
    private String applyFor;
    
//  @Column(name = "other")
    private String other;

    public CommonTravelData() {
    }

    public CommonTravelData(String dateOfTravel, String travelFor, String project, String businessUnit,
                            String organisation, String trip, String tripDescription, String location,
                            String foreignExchange, String applyFor, String other) {
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
}

//@Entity
//@Table(name = "TravelMultipleData")
class TravelMultipleData {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "id")
    private int id;
    
//  @ManyToOne
//  @JoinColumn(name = "employee_travel_request_id", nullable = false)
//  private EmployeeTravelRequest employeeTravelRequest;
    
//  @Column(name = "type")
    private String type;
    
//  @Column(name = "location")
    private String location;
    
//  @Column(name = "from_location")
    private String from;
    
//  @Column(name = "to_location")
    private String to;
    
//  @Column(name = "check_in")
    private String checkIn;
    
//  @Column(name = "check_out")
    private String checkOut;
    
//  @Column(name = "departure")
    private String departure;
    
    public TravelMultipleData() {
    }

    public TravelMultipleData(int id, String type, String location, String from, String to, String checkIn, String checkOut, String departure) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.from = from;
        this.to = to;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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
        return checkOut;
    }

    public void setDeparture(String departure) {
    }    
}


//CREATE TABLE EmployeeTravelRequest (
//	    id BIGINT IDENTITY PRIMARY KEY,
//	    dateOfTravel DATE,
//	    travelFor VARCHAR(255),
//	    project VARCHAR(255),
//	    businessUnit VARCHAR(255),
//	    organisation VARCHAR(255),
//	    trip VARCHAR(255),
//	    tripDescription TEXT,
//	    location VARCHAR(255),
//	    foreignExchange VARCHAR(255),
//	    applyFor VARCHAR(255),
//	    other TEXT
//	);



//CREATE TABLE TravelMultipleData (
//    id INT IDENTITY PRIMARY KEY,
//    employeeTravelRequestId BIGINT,
//    type VARCHAR(255),
//    location VARCHAR(255),
//    fromLocation VARCHAR(255),
//    toLocation VARCHAR(255),
//    checkIn DATETIME,
//    checkOut DATETIME,
//    departure DATETIME,
//    FOREIGN KEY (employeeTravelRequestId) REFERENCES EmployeeTravelRequest(id)
//);

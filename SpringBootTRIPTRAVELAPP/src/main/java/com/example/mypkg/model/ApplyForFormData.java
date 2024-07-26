package com.example.mypkg.model;


//@Entity
public class ApplyForFormData {
  //  @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateOfTravel;
    private String travelFor;
    private String project;
    private String businessUnit;
    private String organisation;
    private String trip;
    private String tripDescription;
    private String location;
    private String foreignExchange;
    private String applyFor;
    private String other;
    private Long travelId;
    //private String travelId;
    //private Long empId;
    private String approvalStatus;
    
    public ApplyForFormData() {
    	
    }
    public ApplyForFormData(Long id, String dateOfTravel, String travelFor, String project, String businessUnit,
			String organisation, String trip, String tripDescription, String location, String foreignExchange,
			String applyFor, String other, Long travelId, String approvalStatus ) {
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
	    this.travelId = travelId;
		//this.empId = empId;
	    this.approvalStatus = approvalStatus;
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
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
//	public Long getEmpId() {
//		return empId;
//	}
//	public void setEmpId(Long empId) {
//		this.empId = empId;
//	}
//	
	public void setTravelId(Long travelId) {
		this.travelId = travelId;
	}
	
	public Long getTravelId() {
		return travelId;
	}
	

    // Constructors, getters, and setters
}

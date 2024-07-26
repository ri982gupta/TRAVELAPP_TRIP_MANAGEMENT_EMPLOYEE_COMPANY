//package com.example.mypkg.model;
//
//public class CombinedDataRequest {
//    private ApplyForformData applyForformData;
//    private FilteredData filteredData;
//
//    public ApplyForformData getApplyForformData() {
//        return applyForformData;
//    }
//
//    public void setApplyForformData(ApplyForformData applyForformData) {
//        this.applyForformData = applyForformData;
//    }
//
//    public FilteredData getFilteredData() {
//        return filteredData;
//    }
//
//    public void setFilteredData(FilteredData filteredData) {
//        this.filteredData = filteredData;
//    }
//}
//
//
//


//package com.example.mypkg.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//public class ApplyForformData {
//    @JsonProperty("dateOfTravel")
//    private String dateOfTravel;
//
//    @JsonProperty("travelFor")
//    private String travelFor;
//
//    @JsonProperty("project")
//    private String project;
//
//    @JsonProperty("businessUnit")
//    private String businessUnit;
//
//    @JsonProperty("organisation")
//    private String organisation;
//    
//    public ApplyForformData() {
//    	
//    }
//
//    public ApplyForformData(String dateOfTravel, String travelFor, String project, String businessUnit,
//			String organisation, String trip, String tripDescription, String location, String foreignExchange,
//			String applyFor, String other, String travelId) {
//		super();
//		this.dateOfTravel = dateOfTravel;
//		this.travelFor = travelFor;
//		this.project = project;
//		this.businessUnit = businessUnit;
//		this.organisation = organisation;
//		this.trip = trip;
//		this.tripDescription = tripDescription;
//		this.location = location;
//		this.foreignExchange = foreignExchange;
//		this.applyFor = applyFor;
//		this.other = other;
//		this.travelId = travelId;
//	}
//
//	public String getDateOfTravel() {
//		return dateOfTravel;
//	}
//
//	public void setDateOfTravel(String dateOfTravel) {
//		this.dateOfTravel = dateOfTravel;
//	}
//
//	public String getTravelFor() {
//		return travelFor;
//	}
//
//	public void setTravelFor(String travelFor) {
//		this.travelFor = travelFor;
//	}
//
//	public String getProject() {
//		return project;
//	}
//
//	public void setProject(String project) {
//		this.project = project;
//	}
//
//	public String getBusinessUnit() {
//		return businessUnit;
//	}
//
//	public void setBusinessUnit(String businessUnit) {
//		this.businessUnit = businessUnit;
//	}
//
//	public String getOrganisation() {
//		return organisation;
//	}
//
//	public void setOrganisation(String organisation) {
//		this.organisation = organisation;
//	}
//
//	public String getTrip() {
//		return trip;
//	}
//
//	public void setTrip(String trip) {
//		this.trip = trip;
//	}
//
//	public String getTripDescription() {
//		return tripDescription;
//	}
//
//	public void setTripDescription(String tripDescription) {
//		this.tripDescription = tripDescription;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public String getForeignExchange() {
//		return foreignExchange;
//	}
//
//	public void setForeignExchange(String foreignExchange) {
//		this.foreignExchange = foreignExchange;
//	}
//
//	public String getApplyFor() {
//		return applyFor;
//	}
//
//	public void setApplyFor(String applyFor) {
//		this.applyFor = applyFor;
//	}
//
//	public String getOther() {
//		return other;
//	}
//
//	public void setOther(String other) {
//		this.other = other;
//	}
//
//	public String getTravelId() {
//		return travelId;
//	}
//
//	public void setTravelId(String travelId) {
//		this.travelId = travelId;
//	}
//
//	@JsonProperty("trip")
//    private String trip;
//
//    @JsonProperty("tripDescription")
//    private String tripDescription;
//
//    @JsonProperty("location")
//    private String location;
//
//    @JsonProperty("foreignExchange")
//    private String foreignExchange;
//
//    @JsonProperty("applyFor")
//    private String applyFor;
//
//    @JsonProperty("other")
//    private String other;
//
//    @JsonProperty("travelId")
//    private String travelId;
//
//    // Add getters and setters
//}
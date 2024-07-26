//package com.example.mypkg.model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//public class FilteredData {
//    @JsonProperty("id")
//    private int id;
//
//    @JsonProperty("type")
//    private String type;
//    
//    public FilteredData() {
//    	
//    }
//
//    public FilteredData(int id, String type, String location, String from, String to, String checkIn, String checkOut,
//			String departure) {
//		super();
//		this.id = id;
//		this.type = type;
//		this.location = location;
//		this.from = from;
//		this.to = to;
//		this.checkIn = checkIn;
//		this.checkOut = checkOut;
//		this.departure = departure;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
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
//	public String getFrom() {
//		return from;
//	}
//
//	public void setFrom(String from) {
//		this.from = from;
//	}
//
//	public String getTo() {
//		return to;
//	}
//
//	public void setTo(String to) {
//		this.to = to;
//	}
//
//	public String getCheckIn() {
//		return checkIn;
//	}
//
//	public void setCheckIn(String checkIn) {
//		this.checkIn = checkIn;
//	}
//
//	public String getCheckOut() {
//		return checkOut;
//	}
//
//	public void setCheckOut(String checkOut) {
//		this.checkOut = checkOut;
//	}
//
//	public String getDeparture() {
//		return departure;
//	}
//
//	public void setDeparture(String departure) {
//		this.departure = departure;
//	}
//
//	@JsonProperty("location")
//    private String location;
//
//    @JsonProperty("from")
//    private String from;
//
//    @JsonProperty("to")
//    private String to;
//
//    @JsonProperty("checkIn")
//    private String checkIn;
//
//    @JsonProperty("checkOut")
//    private String checkOut;
//
//    @JsonProperty("departure")
//    private String departure;
//
//    // Add getters and setters
//}
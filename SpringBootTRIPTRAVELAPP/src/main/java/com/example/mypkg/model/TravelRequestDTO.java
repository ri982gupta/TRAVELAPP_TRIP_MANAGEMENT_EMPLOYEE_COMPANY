package com.example.mypkg.model;

public class TravelRequestDTO {
	private String destination;
    private String date;
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TravelRequestDTO() {
		
	}
	public TravelRequestDTO(String destination, String date) {
		super();
		this.destination = destination;
		this.date = date;
	}

}

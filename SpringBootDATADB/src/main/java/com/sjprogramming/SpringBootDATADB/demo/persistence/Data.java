package com.sjprogramming.SpringBootDATADB.demo.persistence;

import javax.persistence.*;

@Entity
@Table(name = "Data")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    

    @Column(nullable = false)
    private String type;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "from_loc", nullable = false)
    private String from;

    @Column(name = "to_loc", nullable = false)
    private String to;

    @Column(name = "checkIn", nullable = false)
    private String checkIn;

    @Column(name = "checkOut", nullable = false)
    private String checkOut;

    @Column(name = "departure", nullable = false)
    private String departure;
    
    @Column(name = "travelId", nullable = false) // Nullable because it will be populated based on ApplyForFormData
    private Long travelId;

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
		this.travelId = travelId;
	}
  
  public Data() {
  	
  }
}

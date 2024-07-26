package com.example.mypkg.model;

//@Entity
//@Table(name = "DomesticData")
public class DomesticData {
	
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
    private Long id;
    
  //@Column(name = "empid")
    private String empId;
    
  //@Column(name = "data")
    private String data;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}


//
//CREATE TABLE InternationalData (
//    id INT IDENTITY PRIMARY KEY,
//    empId VARCHAR(255),
//    data VARCHAR(255)
//);
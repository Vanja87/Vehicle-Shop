package com.web.project.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 6911996281193478192L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
    private Integer id;
	@Column(name = "NAME")
    private String name;
	@Column(name = "AGE")
    private int age;
	@Column(name = "DESCRIPTION")
    private String description;
	@Column(name = "ACTUAL_MILES")
    private int actualMiles;
	@Column(name = "IMAGE_PATH")
    private String imagePath;
	@Column(name = "PRICE")
    private int price;
	@Column(name = "LOCATION")
    private String location;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_MODEL_ID")
    private VehicleModel vehicleModel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_MANUFACTURER_ID")
    private VehicleManufacturer vehicleManufacturer;
	@OneToOne
	@JoinColumn(name="VEHICLE_TYPE_ID")
	private VehicleType vehicleType;
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "VEHICLE", cascade = CascadeType.ALL)
//    private BodyStyle bodyStyle;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getActualMiles() {
		return actualMiles;
	}
	public void setActualMiles(int actualMiles) {
		this.actualMiles = actualMiles;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public VehicleManufacturer getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(VehicleManufacturer vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
//	public BodyStyle getBodyStyle() {
//		return bodyStyle;
//	}
//	public void setBodyStyle(BodyStyle bodyStyle) {
//		this.bodyStyle = bodyStyle;
//	}
    
}

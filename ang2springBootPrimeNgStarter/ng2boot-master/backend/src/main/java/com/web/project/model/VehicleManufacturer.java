package com.web.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "VEHICLE_MANUFACTURER")
public class VehicleManufacturer implements Serializable {

	private static final long serialVersionUID = -2834648729191037674L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
    private Integer id;
	@Column(name = "VEHICLE_MANUFACTURER_NAME")
    private String name;
	@OneToMany(mappedBy = "vehicleManufacturer")
	private List<Vehicle> vehicles;
	@OneToMany(mappedBy = "vehicleManufacturer")
	private List<VehicleModel> vehicleModels;
	@OneToMany(mappedBy = "vehicleManufacturer")
	private List<VehicleTypeManufacturer> vehicleTypeManufacturers;
	
    
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
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public List<VehicleTypeManufacturer> getVehicleTypeManufacturers() {
		return vehicleTypeManufacturers;
	}
	public void setVehicleTypeManufacturers(List<VehicleTypeManufacturer> vehicleTypeManufacturers) {
		this.vehicleTypeManufacturers = vehicleTypeManufacturers;
	}
    
}

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

@Table(name = "VEHICLE_TYPE")
@Entity 
public class VehicleType implements Serializable {
	
	private static final long serialVersionUID = 4792732028363933328L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
    private Integer id;
	@Column(name = "VEHICLE_TYPE_NAME")
    private String name;
	@OneToMany(mappedBy = "vehicleType")
	private List<VehicleTypeManufacturer> vehicleTypeManufacturers;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vehicleType", cascade = CascadeType.ALL)
	private Vehicle vehicle;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vehicleType", cascade = CascadeType.ALL)
	private VehicleModel vehicleModel;
	
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
	public List<VehicleTypeManufacturer> getVehicleTypeManufacturers() {
		return vehicleTypeManufacturers;
	}
	public void setVehicleTypeManufacturers(List<VehicleTypeManufacturer> vehicleTypeManufacturers) {
		this.vehicleTypeManufacturers = vehicleTypeManufacturers;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}

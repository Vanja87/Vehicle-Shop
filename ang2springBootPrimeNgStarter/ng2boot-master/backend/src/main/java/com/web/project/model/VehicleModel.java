package com.web.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "VEHICLE_MODEL") 
public class VehicleModel implements Serializable {
	
	private static final long serialVersionUID = 440466392090267620L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
    private Integer id;
	@Column(name = "VEHICLE_MODEL_NAME")
    private String name;
	@OneToMany(mappedBy = "vehicleModel")
	private List<Vehicle> vehicles;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_MANUFACTURER_ID")
    private VehicleManufacturer vehicleManufacturer;
	@OneToOne
	@JoinColumn(name="VEHICLE_TYPE_ID")
	private VehicleType vehicleType;
    
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
	public VehicleManufacturer getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(VehicleManufacturer vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
    
    
}

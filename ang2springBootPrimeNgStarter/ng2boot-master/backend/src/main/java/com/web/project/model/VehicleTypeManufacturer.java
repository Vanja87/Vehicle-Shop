package com.web.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "TYPE_MANUFACTURER")
@Entity 
public class VehicleTypeManufacturer implements Serializable {
	
	private static final long serialVersionUID = 308649186539803536L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
    private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_MANUFACTURER_ID")
    private VehicleManufacturer vehicleManufacturer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_TYPE_ID")
    private VehicleType vehicleType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public VehicleManufacturer getVehicleManufacturer() {
		return vehicleManufacturer;
	}
	public void setVehicleManufacturer(VehicleManufacturer vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
		
}

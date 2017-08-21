package com.web.project.persistence;

import java.util.List;

import com.web.project.model.VehicleManufacturer;

public interface VehicleManufacturerDaoCustom {
	
	public List<VehicleManufacturer> getVehicleManufacturersByType(String typeName);

}

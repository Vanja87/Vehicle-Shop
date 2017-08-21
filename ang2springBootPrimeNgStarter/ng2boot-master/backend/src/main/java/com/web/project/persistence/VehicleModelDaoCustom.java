package com.web.project.persistence;

import java.util.List;

import com.web.project.model.VehicleModel;

public interface VehicleModelDaoCustom {
	
	public List<VehicleModel> getVehicleModelsByManufacturer(String manufacturerName, String typeName);

}

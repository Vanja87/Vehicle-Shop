package com.web.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.project.model.Vehicle;
import com.web.project.model.VehicleManufacturer;
import com.web.project.model.VehicleModel;
import com.web.project.persistence.VehicleDao;
import com.web.project.persistence.VehicleManufacturerDao;
import com.web.project.persistence.VehicleModelDao;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private VehicleManufacturerDao vehicleManufacturerDao;
	@Autowired
	private VehicleModelDao vehicleModelDao;

	@Override
	public List<Vehicle> findAll() {
		return this.vehicleDao.findAll();
	}

	@Override
	public List<Vehicle> getVehiclesByModelAndManufacturer(final String manufacturerName,
			                                               final String modelName, 
			                                               final String typeName) {
		return this.vehicleDao.getVehiclesByModelAndManufacturer(manufacturerName, modelName, typeName);
	}

	@Override
	public List<VehicleModel> getVehicleModelsByManufacturer(final String manufacturerName, 
														     final String typeName) {
		return this.vehicleModelDao.getVehicleModelsByManufacturer(manufacturerName, typeName);
	}

	@Override
	public List<VehicleManufacturer> getVehicleManufacturersByType(final String typeName) {
		return this.vehicleManufacturerDao.getVehicleManufacturersByType(typeName);
	}

}

package com.web.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import com.web.project.model.QVehicle;
import com.web.project.model.QVehicleManufacturer;
import com.web.project.model.QVehicleModel;
import com.web.project.model.QVehicleType;
import com.web.project.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDaoCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Vehicle> getVehiclesByModelAndManufacturer(final String manufacturerName, 
														   final String modelName, 
														   final String typeName) {
		final QVehicle qVehicle = QVehicle.vehicle;
		final QVehicleModel qVehicleModel = QVehicleModel.vehicleModel;
		final QVehicleManufacturer qVehicleManufacturer = QVehicleManufacturer.vehicleManufacturer;
		final QVehicleType qVehicleType = QVehicleType.vehicleType;

		JPAQuery query = new JPAQuery(this.entityManager).from(qVehicle)
				.join(qVehicle.vehicleType(), qVehicleType).on(qVehicleType.name.eq(typeName))
				.join(qVehicle.vehicleManufacturer(), qVehicleManufacturer)
				.join(qVehicle.vehicleModel(), qVehicleModel);
		
		if (!"null".equals(manufacturerName) && !"null".equals(modelName)) {
			query.where(qVehicleModel.name.eq(modelName),
					   	qVehicleManufacturer.name.eq(manufacturerName));
		} else if ("null".equals(manufacturerName) && !"null".equals(modelName)) {
			query.where(qVehicleModel.name.eq(modelName));
		} else if (!"null".equals(manufacturerName) && "null".equals(modelName)) {
			query.where(qVehicleManufacturer.name.eq(manufacturerName));
		}

	    return query.list(Projections.bean(Vehicle.class,
						                   qVehicle.id.as("id"),						               
						                   qVehicle.name.as("name"),
						                   qVehicle.actualMiles.as("actualMiles"),
						                   qVehicle.age.as("age"),
						                   qVehicle.description.as("description")
						               	));
		
	}

}

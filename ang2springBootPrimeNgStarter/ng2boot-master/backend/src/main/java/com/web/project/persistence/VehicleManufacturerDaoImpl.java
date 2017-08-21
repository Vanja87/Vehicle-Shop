package com.web.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import com.web.project.model.QVehicleManufacturer;
import com.web.project.model.QVehicleType;
import com.web.project.model.QVehicleTypeManufacturer;
import com.web.project.model.VehicleManufacturer;

@Repository
public class VehicleManufacturerDaoImpl implements VehicleManufacturerDaoCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<VehicleManufacturer> getVehicleManufacturersByType(String typeName) {
		final QVehicleManufacturer qVehicleManufacturer = QVehicleManufacturer.vehicleManufacturer;
		final QVehicleType qVehicleType = QVehicleType.vehicleType;
		final QVehicleTypeManufacturer typeManufacturer = QVehicleTypeManufacturer.vehicleTypeManufacturer;
        
		JPAQuery query = new JPAQuery(this.entityManager).from(qVehicleManufacturer)
							.join(qVehicleManufacturer.vehicleTypeManufacturers, typeManufacturer)
							.join(typeManufacturer.vehicleType(), qVehicleType); 
		
		return query.where(qVehicleType.name.eq(typeName))
				     .list(Projections.bean(VehicleManufacturer.class,
				   						    qVehicleManufacturer.id.as("id"),						               
				   						    qVehicleManufacturer.name.as("name")));
	}

}

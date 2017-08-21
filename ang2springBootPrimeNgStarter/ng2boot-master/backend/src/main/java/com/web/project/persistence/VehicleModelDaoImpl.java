package com.web.project.persistence;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import com.web.project.model.QVehicleManufacturer;
import com.web.project.model.QVehicleModel;
import com.web.project.model.QVehicleType;
import com.web.project.model.VehicleModel;

@Repository
public class VehicleModelDaoImpl implements VehicleModelDaoCustom {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<VehicleModel> getVehicleModelsByManufacturer(final String manufacturerName, 
			                                                 final String typeName) {
		final QVehicleModel qVehicleModel = QVehicleModel.vehicleModel;
		final QVehicleManufacturer qVehicleManufacturer = QVehicleManufacturer.vehicleManufacturer;
		final QVehicleType qVehicleType = QVehicleType.vehicleType;

		JPAQuery query = new JPAQuery(this.entityManager).from(qVehicleModel)
				.join(qVehicleModel.vehicleType(), qVehicleType).on(qVehicleType.name.eq(typeName))
				.join(qVehicleModel.vehicleManufacturer(), qVehicleManufacturer);
		
		if (!"null".equals(manufacturerName)) {
			query.where(qVehicleManufacturer.name.eq(manufacturerName));
		} 
		
		return query.list(Projections.bean(VehicleModel.class,
						                   qVehicleModel.id.as("id"),						               
						                   qVehicleModel.name.as("name")));
	}
}

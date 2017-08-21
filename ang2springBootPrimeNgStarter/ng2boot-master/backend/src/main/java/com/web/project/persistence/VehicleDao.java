package com.web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.web.project.model.Vehicle;
@RepositoryDefinition(domainClass = Vehicle.class,
                      idClass = Long.class)
public interface VehicleDao extends JpaRepository<Vehicle, Long>, VehicleDaoCustom {

}

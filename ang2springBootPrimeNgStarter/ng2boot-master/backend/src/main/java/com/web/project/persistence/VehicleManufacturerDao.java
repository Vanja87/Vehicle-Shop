package com.web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.web.project.model.VehicleManufacturer;
@RepositoryDefinition(domainClass = VehicleManufacturer.class,
                      idClass = Long.class)
public interface VehicleManufacturerDao extends JpaRepository<VehicleManufacturer, Long>, VehicleManufacturerDaoCustom {

}

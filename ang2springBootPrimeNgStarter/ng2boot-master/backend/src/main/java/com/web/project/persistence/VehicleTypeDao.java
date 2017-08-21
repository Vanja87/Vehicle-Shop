package com.web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.web.project.model.VehicleType;
@RepositoryDefinition(domainClass = VehicleType.class,
                      idClass = Long.class)
public interface VehicleTypeDao extends JpaRepository<VehicleType, Long>, VehicleTypeDaoCustom {

}

package com.web.project.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import com.web.project.model.VehicleModel;
@RepositoryDefinition(domainClass = VehicleModel.class,
                      idClass = Long.class)
public interface VehicleModelDao extends JpaRepository<VehicleModel, Long>, VehicleModelDaoCustom {

}

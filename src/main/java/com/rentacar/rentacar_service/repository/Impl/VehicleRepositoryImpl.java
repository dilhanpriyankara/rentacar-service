package com.rentacar.rentacar_service.repository.Impl;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.model.Vehicle;
import com.rentacar.rentacar_service.repository.VehicleRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepositoryImpl implements VehicleRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Vehicle createOrUpdateVehicleData(Vehicle vehicle) {
     return  entityManager.merge(vehicle);
  }
}

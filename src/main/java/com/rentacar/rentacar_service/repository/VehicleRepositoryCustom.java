package com.rentacar.rentacar_service.repository;

import com.rentacar.rentacar_service.model.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositoryCustom {
  public  Vehicle createOrUpdateVehicleData(Vehicle vehicle);
}

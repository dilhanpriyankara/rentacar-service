package com.rentacar.rentacar_service.enums;

import lombok.Getter;

@Getter
public enum VehicleType {

  CAR("Car"),
  VAN("Van"),
  SUV("SUV"),
  JEEP("Jeep"),
  BIKE("Bike");

  private final String label;

  VehicleType(String label) {
    this.label = label;
  }
}

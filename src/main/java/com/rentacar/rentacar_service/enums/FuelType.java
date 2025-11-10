package com.rentacar.rentacar_service.enums;

import lombok.Getter;

@Getter
public enum FuelType {
  PETROL("Petrol"),
  DIESEL("Diesel"),
  HYBRID("Hybrid"),
  ELECTRIC("Electric");

  private final String label;

  FuelType(String label) {
    this.label = label;
  }
}

package com.rentacar.rentacar_service.enums;

import lombok.Getter;

@Getter
public enum TransmissionType {
  MANUAL("Manual"),
  AUTO("Automatic");

  private final String label;

  TransmissionType(String label) {
    this.label = label;
  }
}

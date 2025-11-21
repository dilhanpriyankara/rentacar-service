package com.rentacar.rentacar_service.dto;

import com.rentacar.rentacar_service.enums.FuelType;
import com.rentacar.rentacar_service.enums.Status;
import com.rentacar.rentacar_service.enums.TransmissionType;
import com.rentacar.rentacar_service.enums.VehicleType;
import lombok.Data;

@Data
public class VehicleRequestDto {
  private Long ownerId;
  private Long districtId;
  private Long cityId;
  private String title;
  private String brand;
  private String model;
  private Integer year;
  private VehicleType vehicleType;
  private Integer seats;
  private FuelType fuelType;
  private TransmissionType transmissionType;
  private Double pricePerDay;
  private Double allowedKilometersPerDay;
  private Double pricePerMonth;
  private String description;
  private Status status;
}

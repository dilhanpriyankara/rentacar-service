package com.rentacar.rentacar_service.dto;

import com.rentacar.rentacar_service.enums.FuelType;
import com.rentacar.rentacar_service.enums.Status;
import com.rentacar.rentacar_service.enums.TransmissionType;
import com.rentacar.rentacar_service.enums.VehicleType;

public record VehicleResponseDto(Long id,
                                 Long ownerId,
                                 String title,
                                 String brand,
                                 String model,
                                 Integer year,
                                 VehicleType vehicleType,
                                 Integer seats,
                                 FuelType fuelType,
                                 TransmissionType transmissionType,
                                 double pricePerDay,
                                 double allowedKilometersPerDay,
                                 double pricePerMonth,
                                 String description,
                                 Integer districtId,
                                 Integer cityId,
                                 Status status,
                                 String districtName,
                                 String cityName,
                                 String ownerFirstName,
                                 String ownerLastName,
                                 String ownerContactNo) {


}

package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.model.Vehicle;
import com.rentacar.rentacar_service.repository.CityRepository;
import com.rentacar.rentacar_service.repository.DistrictRepository;
import com.rentacar.rentacar_service.repository.UserRepository;
import com.rentacar.rentacar_service.repository.VehicleRepositoryCustom;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepositoryCustom vehicleRepositoryCustom;
  private final UserRepository userRepository;
  private final DistrictRepository districtRepository;
  private final CityRepository cityRepository;

  public VehicleService(VehicleRepositoryCustom vehicleRepositoryCustom,
      DistrictRepository districtRepository,
      CityRepository cityRepository,
      UserRepository userRepository) {
    this.vehicleRepositoryCustom = vehicleRepositoryCustom;
    this.userRepository = userRepository;
    this.districtRepository = districtRepository;
    this.cityRepository = cityRepository;
  }

  @Transactional
  public void createOrUpdateVehicleData(VehicleRequestDto vehicleRequestDto) {
    Vehicle vehicle = new Vehicle();
    vehicle.setTitle(vehicleRequestDto.getTitle());
    vehicle.setBrand(vehicleRequestDto.getBrand());
    vehicle.setModel(vehicleRequestDto.getModel());
    vehicle.setYear(vehicleRequestDto.getYear());
    vehicle.setPricePerDay(vehicleRequestDto.getPricePerDay());
    vehicle.setAllowedKilometersPerDay(vehicleRequestDto.getAllowedKilometersPerDay());
    vehicle.setPricePerMonth(vehicleRequestDto.getPricePerMonth());
    vehicle.setFuelType(vehicleRequestDto.getFuelType());
    vehicle.setVehicleType(vehicleRequestDto.getVehicleType());
    vehicle.setTransmissionType(vehicleRequestDto.getTransmissionType());
    vehicle.setSeats(vehicleRequestDto.getSeats());
    vehicle.setStatus(vehicleRequestDto.getStatus());
    vehicle.setDescription(vehicleRequestDto.getDescription());

    vehicle.setOwner(userRepository.findById(vehicleRequestDto.getOwnerId())
        .orElseThrow(() -> new RuntimeException("User not found")));

    vehicle.setDistrict(districtRepository.findById(vehicleRequestDto.getDistrictId())
        .orElseThrow(() -> new RuntimeException("District not found")));

    vehicle.setCity(cityRepository.findById(vehicleRequestDto.getCityId())
        .orElseThrow(() -> new RuntimeException("City not found")));

    Vehicle persistedVehicle = vehicleRepositoryCustom.createOrUpdateVehicleData(vehicle);
  }
}

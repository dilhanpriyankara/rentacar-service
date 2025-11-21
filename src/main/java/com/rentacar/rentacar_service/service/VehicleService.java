package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.dto.VehicleResponseDto;
import com.rentacar.rentacar_service.enums.Status;
import com.rentacar.rentacar_service.model.Vehicle;
import com.rentacar.rentacar_service.repository.CityRepository;
import com.rentacar.rentacar_service.repository.DistrictRepository;
import com.rentacar.rentacar_service.repository.UserRepository;
import com.rentacar.rentacar_service.repository.VehicleRepository;
import com.rentacar.rentacar_service.repository.VehicleRepositoryCustom;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepositoryCustom vehicleRepositoryCustom;
  private final UserRepository userRepository;
  private final DistrictRepository districtRepository;
  private final CityRepository cityRepository;
  private final VehicleRepository vehicleRepository;

  public VehicleService(VehicleRepositoryCustom vehicleRepositoryCustom,
      DistrictRepository districtRepository,
      CityRepository cityRepository,
      UserRepository userRepository, VehicleRepository vehicleRepository) {
    this.vehicleRepositoryCustom = vehicleRepositoryCustom;
    this.userRepository = userRepository;
    this.districtRepository = districtRepository;
    this.cityRepository = cityRepository;
    this.vehicleRepository = vehicleRepository;
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

  public Page<VehicleResponseDto> getAllVehicles(Pageable pageable) {
    Page<Vehicle> vehiclePage = vehicleRepository.findAll(pageable);

    return vehiclePage.map(this::convertToDto);
  }

  private VehicleResponseDto convertToDto(Vehicle vehicle) {
    return new VehicleResponseDto(
        vehicle.getId(),
        vehicle.getOwner().getId(),
        vehicle.getTitle(),
        vehicle.getBrand(),
        vehicle.getModel(),
        vehicle.getYear(),
        vehicle.getVehicleType(),
        vehicle.getSeats(),
        vehicle.getFuelType(),
        vehicle.getTransmissionType(),
        vehicle.getPricePerDay(),
        vehicle.getAllowedKilometersPerDay(),
        vehicle.getPricePerMonth(),
        vehicle.getDescription(),
        vehicle.getDistrict().getId(),
        vehicle.getCity().getId(),
        vehicle.getStatus(),
        vehicle.getDistrict().getName(),
        vehicle.getCity().getName(),
        vehicle.getOwner().getFirstName(),
        vehicle.getOwner().getLastName(),
        vehicle.getOwner().getPhoneNumber()
    );
  }

  @Transactional
  public void updateStatus(Long id, Status status) {
    Vehicle vehicle = vehicleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    vehicle.setStatus(status);
    // JPA automatically saves changes at transaction commit
  }
}

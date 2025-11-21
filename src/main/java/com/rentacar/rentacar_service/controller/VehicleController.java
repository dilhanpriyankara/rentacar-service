package com.rentacar.rentacar_service.controller;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.dto.VehicleResponseDto;
import com.rentacar.rentacar_service.enums.Status;
import com.rentacar.rentacar_service.service.VehicleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @PostMapping("/create")
  public ResponseEntity<String> createVehicleDetails(@RequestBody VehicleRequestDto dto) {
    vehicleService.createOrUpdateVehicleData(dto);
    return ResponseEntity.ok("Vehicle created successfully");
  }

  @PostMapping("/search")
  public Page<VehicleResponseDto> getAllVehicle(@RequestBody VehicleRequestDto req,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "id") String sortBy) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return vehicleService.getAllVehicles(req,pageable);
  }

  @PatchMapping("status/{id}")
  public ResponseEntity<String> updateVehicleStatus(@PathVariable Long id,
      @RequestParam Status status) {
    vehicleService.updateStatus(id, status);
    return ResponseEntity.ok("Status updated successfully");
  }
}

package com.rentacar.rentacar_service.controller;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

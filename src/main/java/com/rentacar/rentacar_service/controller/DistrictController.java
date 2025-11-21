package com.rentacar.rentacar_service.controller;

import com.rentacar.rentacar_service.dto.DistrictResponseDto;
import com.rentacar.rentacar_service.model.District;
import com.rentacar.rentacar_service.service.DistrictService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("district")
public class DistrictController {

  final private DistrictService districtService;

  public DistrictController(DistrictService districtService) {
    this.districtService = districtService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<DistrictResponseDto>> getAll() {
    return districtService.getAll();
  }
}

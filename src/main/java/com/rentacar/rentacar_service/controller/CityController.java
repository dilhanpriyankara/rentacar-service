package com.rentacar.rentacar_service.controller;

import com.rentacar.rentacar_service.dto.CityResponseDto;
import com.rentacar.rentacar_service.service.CityService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {

  final private CityService cityService;

  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping("/by/district/{id}")
  public ResponseEntity<List<CityResponseDto>> getByDistrict(@PathVariable Long id){
    return cityService.getByDistrict(id);
  }
}

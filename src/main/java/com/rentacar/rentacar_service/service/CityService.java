package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.dto.CityResponseDto;
import com.rentacar.rentacar_service.model.City;
import com.rentacar.rentacar_service.repository.CityRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CityService {

  final private CityRepository cityRepository;

  public CityService(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  public ResponseEntity<List<CityResponseDto>> getByDistrict(Long id) {
    List<City> cities = cityRepository.findByDistrictId(id);
    return ResponseEntity.ok(convertToCityResponseDto(cities));
  }

  private List<CityResponseDto> convertToCityResponseDto(List<City> cities) {
    return cities.stream()
        .map(city -> new CityResponseDto(city.getId(), city.getName(), city.getDistrict().getId()))
        .toList();
  }
}

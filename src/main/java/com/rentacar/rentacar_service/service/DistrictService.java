package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.dto.DistrictResponseDto;
import com.rentacar.rentacar_service.model.District;
import com.rentacar.rentacar_service.repository.DistrictRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

  final private DistrictRepository districtRepository;

  public DistrictService(DistrictRepository districtRepository) {
    this.districtRepository = districtRepository;
  }

  public ResponseEntity<List<DistrictResponseDto>> getAll() {
    List<District> districts = districtRepository.findAll();
    return ResponseEntity.ok(convertToDistrictResponseDto(districts));
  }

  private List<DistrictResponseDto> convertToDistrictResponseDto(List<District> districts) {
    return districts.stream()
        .map(district -> new DistrictResponseDto(district.getId(), district.getName())).toList();
  }
}

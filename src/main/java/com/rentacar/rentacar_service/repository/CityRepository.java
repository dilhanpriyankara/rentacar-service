package com.rentacar.rentacar_service.repository;

import com.rentacar.rentacar_service.model.City;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  public List<City> findByDistrictId(Long id);
}

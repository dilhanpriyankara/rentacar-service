package com.rentacar.rentacar_service.repository.Specification;

import com.rentacar.rentacar_service.dto.VehicleRequestDto;
import com.rentacar.rentacar_service.model.Vehicle;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecification {

  public static Specification<Vehicle> withFilters(VehicleRequestDto req) {

    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (req.getBrand() != null) {
        predicates.add(
            cb.like(cb.lower(root.get("brand")), "%" + req.getBrand().toLowerCase() + "%"));
      }

      if (req.getModel() != null) {
        predicates.add(
            cb.like(cb.lower(root.get("model")), "%" + req.getModel().toLowerCase() + "%"));
      }

      if (req.getYear() != null) {
        predicates.add(cb.equal(root.get("year"), req.getYear()));
      }

      if (req.getVehicleType() != null) {
        predicates.add(cb.equal(root.get("vehicleType"), req.getVehicleType()));
      }

      if (req.getFuelType() != null) {
        predicates.add(cb.equal(root.get("fuelType"), req.getFuelType()));
      }

      if (req.getTransmissionType() != null) {
        predicates.add(cb.equal(root.get("transmissionType"), req.getTransmissionType()));
      }

      if (req.getSeats() != null) {
        predicates.add(cb.equal(root.get("seats"), req.getSeats()));
      }

      if (req.getPricePerDay() != null) {
        predicates.add(cb.greaterThanOrEqualTo(root.get("pricePerDay"), req.getPricePerDay()));
      }

      if (req.getPricePerMonth() != null) {
        predicates.add(cb.lessThanOrEqualTo(root.get("pricePerMonth"), req.getPricePerMonth()));
      }

      if (req.getDistrictId() != null) {
        predicates.add(cb.equal(root.get("district").get("id"), req.getDistrictId()));
      }

      if (req.getCityId() != null) {
        predicates.add(cb.equal(root.get("city").get("id"), req.getCityId()));
      }

      if (req.getStatus() != null) {
        predicates.add(cb.equal(root.get("status"), req.getStatus()));
      }

      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }
}

package com.rentacar.rentacar_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VehicleImages")
public class VehicleImages extends AuditableEntity{

  @ManyToOne
  private Vehicle vehicle;
  private String imagePath;
}

package com.rentacar.rentacar_service.model;

import com.rentacar.rentacar_service.enums.FuelType;
import com.rentacar.rentacar_service.enums.Status;
import com.rentacar.rentacar_service.enums.TransmissionType;
import com.rentacar.rentacar_service.enums.VehicleType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class Vehicle extends AuditableEntity {

  @ManyToOne
  private User owner;
  private String title;
  private String brand;
  private String model;
  private Integer year;
  @Enumerated(EnumType.STRING)
  private VehicleType vehicleType;
  private Integer seats;
  @Enumerated(EnumType.STRING)
  private FuelType fuelType;
  @Enumerated(EnumType.STRING)
  private TransmissionType transmissionType;
  private double pricePerDay;
  private double allowedKilometersPerDay;
  private double pricePerMonth;
  private String description;
  @OneToOne
  private District district;
  @OneToOne
  private City city;
  @Enumerated(EnumType.STRING)
  private Status status;
  @OneToMany(mappedBy = "vehicle" , cascade = CascadeType.ALL)
  private List<VehicleImages> vehicleImages;
}

package com.rentacar.rentacar_service.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @ManyToOne
  private District district;
  private String name;
  @OneToMany(mappedBy = "city" ,cascade = CascadeType.ALL)
  private List<Vehicle> vehicle;
}

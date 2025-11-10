package com.rentacar.rentacar_service.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import org.apache.catalina.LifecycleState;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "district")
public class District {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  private String name;
  @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<City> cities;
}

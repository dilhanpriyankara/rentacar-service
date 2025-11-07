package com.rentacar.rentacar_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends AuditableEntity {

  private String firstName;
  private String lastName;
  private String email;
  @Transient
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private String phoneNumber;
  private String role;
  private String keyClockId;

}

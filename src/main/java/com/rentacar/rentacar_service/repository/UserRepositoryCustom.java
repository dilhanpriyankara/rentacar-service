package com.rentacar.rentacar_service.repository;

import com.rentacar.rentacar_service.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryCustom {

  User saveUser(User user);
}

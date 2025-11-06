package com.rentacar.rentacar_service.repository;

import com.rentacar.rentacar_service.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

  User saveUser(User user);
}

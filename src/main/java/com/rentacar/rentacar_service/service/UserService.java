package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.model.User;
import com.rentacar.rentacar_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    return userRepository.saveUser(user);
  }

}

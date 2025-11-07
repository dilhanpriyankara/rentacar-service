package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.model.User;
import com.rentacar.rentacar_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;
  private final KeycloakUserService keycloakUserService;

  public UserService(UserRepository userRepository,KeycloakUserService keycloakUserService) {
    this.userRepository = userRepository;
    this.keycloakUserService=keycloakUserService;
  }

  public User createUser(User user) {
    String keyCloakUserId=keycloakUserService.createUserInKeycloak(user);
    user.setKeyClockId(keyCloakUserId);
    return userRepository.saveUser(user);
  }

}

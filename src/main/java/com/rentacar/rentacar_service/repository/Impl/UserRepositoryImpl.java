package com.rentacar.rentacar_service.repository.Impl;

import com.rentacar.rentacar_service.model.User;
import com.rentacar.rentacar_service.repository.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User saveUser(User user) {
    entityManager.persist(user);
    return user;
  }
}

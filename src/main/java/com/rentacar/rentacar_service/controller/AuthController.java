package com.rentacar.rentacar_service.controller;

import com.rentacar.rentacar_service.dto.KeycloakTokenResponse;
import com.rentacar.rentacar_service.dto.LoginRequest;
import com.rentacar.rentacar_service.service.AuthService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    try {
      KeycloakTokenResponse keycloakTokenResponse = authService.login(request.getUsername(),
          request.getPassword());
      return ResponseEntity.ok(keycloakTokenResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body(Map.of("error", e.getMessage()));
    }
  }
}

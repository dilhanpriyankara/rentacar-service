package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.dto.KeycloakTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class AuthService {

  @Value("${keycloak.server-url}")
  private String serverUrl;

  @Value("${keycloak.realm}")
  private String realm;

  @Value("${keycloak.client-id}")
  private String clientId;

  @Value("${keycloak.client-secret}")
  private String clientSecret;

  public KeycloakTokenResponse login(String username, String password) {
    final String tokenUrl = serverUrl+"/realms/"+realm+"/protocol/openid-connect/token";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    MultiValueMap<String, String> body = buildBody(username, password);
    HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
    ResponseEntity<KeycloakTokenResponse> response = restTemplate.exchange(tokenUrl,
        HttpMethod.POST, entity,
        KeycloakTokenResponse.class
    );

    if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
      return response.getBody();
    } else {
      throw new RuntimeException("Invalid credentials");
    }
  }

  private MultiValueMap<String, String> buildBody(String username,
      String password) {
    MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
    body.add("client_id", clientId);
    body.add("client_secret", clientSecret);
    body.add("grant_type", "password");
    body.add("username", username);
    body.add("password", password);
    return body;
  }
}

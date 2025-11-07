package com.rentacar.rentacar_service.dto;

import lombok.Data;

@Data
public class KeycloakTokenResponse {

  private String access_token;
  private String refresh_token;
  private String id_token;
  private int expires_in;
  private int refresh_expires_in;
  private String token_type;
  private String scope;
}

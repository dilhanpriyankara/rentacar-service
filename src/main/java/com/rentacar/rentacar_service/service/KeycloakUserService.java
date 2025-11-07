package com.rentacar.rentacar_service.service;

import com.rentacar.rentacar_service.model.User;
import jakarta.ws.rs.core.Response;
import java.util.Collections;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakUserService {

  private final Keycloak keycloak;

  @Value("${keycloak.realm}")
  private String realm;

  @Autowired
  public KeycloakUserService(Keycloak keycloak) {
    this.keycloak = keycloak;
  }

  public String createUserInKeycloak(User userDto) {
    Response response = createUserInKeyCloak(userDto);
    String keyCloakUserId = setPassWordToUser(userDto, response);
    setUserToRole(keyCloakUserId, userDto.getRole());
    return keyCloakUserId;
  }

  private void setUserToRole(String keyCloakUserId, String roleName) {
    var realmResource = keycloak.realm(realm);
    var role = realmResource.roles().get(roleName).toRepresentation();
    realmResource.users()
        .get(keyCloakUserId)
        .roles()
        .realmLevel()
        .add(Collections.singletonList(role));
  }

  private String setPassWordToUser(User userDto, Response response) {
    String keyCloakUserId = CreatedResponseUtil.getCreatedId(response);
    CredentialRepresentation password = new CredentialRepresentation();
    password.setType(CredentialRepresentation.PASSWORD);
    password.setTemporary(false);
    password.setValue(userDto.getPassword());

    keycloak.realm(realm).users().get(keyCloakUserId).resetPassword(password);
    return keyCloakUserId;
  }

  private Response createUserInKeyCloak(User userDto) {
    UserRepresentation user = new UserRepresentation();
    user.setUsername(userDto.getEmail());
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setEnabled(true);

    Response response = keycloak.realm(realm).users().create(user);
    return response;
  }
}

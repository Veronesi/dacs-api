package com.dacs.api.service;

import org.keycloak.representations.idm.UserRepresentation;

import com.dacs.api.dto.UserDTO;

import java.util.List;

public interface IKeycloakService {
    List<UserRepresentation> findAllUsers();

    List<UserRepresentation> searchUserByUsername(String username);

    UserDTO createUser(UserDTO userDTO);

    void deleteUser(String userId);

    void updateUser(String userId, UserDTO userDTO);
}

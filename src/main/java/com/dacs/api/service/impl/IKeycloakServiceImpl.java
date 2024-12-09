package com.dacs.api.service.impl;

import java.util.List;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import com.dacs.api.dto.UserDTO;
import com.dacs.api.service.IKeycloakService;
import com.dacs.api.util.KeycloakProvider;

import io.micrometer.common.lang.NonNull;
import jakarta.ws.rs.core.Response;

@Service
public class IKeycloakServiceImpl implements IKeycloakService {

    @Override
    public List<UserRepresentation> findAllUsers() {
        return KeycloakProvider.getRealmResources()
                .users()
                .list();
    }

    @Override
    public List<UserRepresentation> searchUserByUsername(String username) {
        return KeycloakProvider.getRealmResources()
                .users()
                .searchByUsername(username, true);
    }

    @Override
    public UserDTO createUser(@NonNull UserDTO userDTO) {
        int status = 9;
        UsersResource userResource = KeycloakProvider.getUsersResource();
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setFirstName(userDTO.getFirstName());
        userRepresentation.setLastName(userDTO.getLastName());
        userRepresentation.setEmail(userDTO.getEmail());
        userRepresentation.setUsername(userDTO.getUsername());
        userRepresentation.setEmailVerified(true);
        userRepresentation.setEnabled(true);
        Response response = userResource.create(userRepresentation);
        status = response.getStatus();

        if (status == 201) {
            String path = response.getLocation().getPath();
            String userId = path.substring(path.lastIndexOf("/") + 1);

            CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
            credentialRepresentation.setTemporary(false);
            credentialRepresentation.setType(OAuth2Constants.PASSWORD);
            credentialRepresentation.setValue(userDTO.getPassword());

            userResource.get(userId).resetPassword(credentialRepresentation);

            RealmResource realmResource = KeycloakProvider.getRealmResources();

            List<RoleRepresentation> roleRepresentations = null;

            roleRepresentations = List.of(realmResource.roles().get("user").toRepresentation());

            realmResource.users().get(userId).roles().realmLevel().add(roleRepresentations);
            userRepresentation.setId(userId);
            userDTO.setUuid(userId);
            return userDTO;
        } else if (status == 409) {
            System.out.println("user exist");
            throw new Error("user exist");
        } else {
            System.out.println("error al crear el usuario");
            throw new Error("error to create exist");
        }
    }

    @Override
    public void deleteUser(String userId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

}

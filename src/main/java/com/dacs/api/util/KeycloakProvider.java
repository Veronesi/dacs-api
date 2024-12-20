package com.dacs.api.util;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

public class KeycloakProvider {
    private static final String SERVER_URL = "http://localhost:8080";
    private static final String REALM_NAME = "dacs";
    private static final String REALM_MASTER = "master";
    private static final String ADMIN_CLI = "admin-cli";
    private static final String USER_CONSOLE = "admin";
    private static final String USER_PASSWORD = "admin";
    private static final String CLIENT_SECRET = "eKiB2A1sJUjUPf8Mf3WER2gG0OgpTFyZ";

    public static RealmResource getRealmResources() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(SERVER_URL)
                .realm(REALM_MASTER)
                .clientId(ADMIN_CLI)
                .username(USER_CONSOLE)
                .password(USER_PASSWORD)
                .clientSecret(CLIENT_SECRET)
                .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                .build();

        return keycloak.realm(REALM_NAME);
    }

    public static UsersResource getUsersResource() {
        RealmResource realmResource = getRealmResources();
        return realmResource.users();
    }
}

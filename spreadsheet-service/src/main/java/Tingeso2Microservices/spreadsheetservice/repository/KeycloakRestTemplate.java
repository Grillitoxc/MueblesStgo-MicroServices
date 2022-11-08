package Tingeso2Microservices.spreadsheetservice.repository;

import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class KeycloakRestTemplate extends RestTemplate implements RestOperations {
    public KeycloakRestTemplate(KeycloakClientRequestFactory factory) {
        super(factory);
    }
}
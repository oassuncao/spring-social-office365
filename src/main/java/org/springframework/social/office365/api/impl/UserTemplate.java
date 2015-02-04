package org.springframework.social.office365.api.impl;

import org.springframework.social.office365.api.UserOperations;
import org.springframework.social.office365.api.domain.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class UserTemplate extends AbstractTemplate implements UserOperations {
// ------------------------------ FIELDS ------------------------------

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;

// --------------------------- CONSTRUCTORS ---------------------------

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorized, String baseUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;

        this.url = baseUrl;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface UserOperations ---------------------

    @Override
    public User getUserProfile() {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/me?api-version=2013-11-08"), User.class);
    }
}

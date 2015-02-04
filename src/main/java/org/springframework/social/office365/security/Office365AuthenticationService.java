package org.springframework.social.office365.security;

import org.springframework.social.office365.api.Office365;
import org.springframework.social.office365.connect.Office365ConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class Office365AuthenticationService extends OAuth2AuthenticationService<Office365> {
// --------------------------- CONSTRUCTORS ---------------------------

    public Office365AuthenticationService(String apiKey, String appSecret) {
        super(new Office365ConnectionFactory(apiKey, appSecret));
    }
}

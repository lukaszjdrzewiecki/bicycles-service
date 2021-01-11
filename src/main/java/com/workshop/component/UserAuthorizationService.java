package com.workshop.component;

import org.springframework.stereotype.Component;
import com.workshop.config.security.component.UserAuthentication;

@Component
public class UserAuthorizationService {

    public boolean isUserAuthorized(String userName, UserAuthentication userAuthentication) {
        return userAuthentication.getName().equals(userName);
    }
}

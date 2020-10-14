package workshop.component;

import org.springframework.stereotype.Component;
import workshop.config.security.component.UserAuthentication;

@Component
public class UserAuthorizationService {

    public boolean isUserAuthorized(String userName, UserAuthentication userAuthentication) {
        return userAuthentication.getName().equals(userName);
    }
}

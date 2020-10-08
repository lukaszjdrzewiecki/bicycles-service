package workshop.config.security.Service;

import workshop.config.security.component.JwtTokenBuilder;
import workshop.config.security.component.UserAuthentication;
import workshop.config.security.dto.LoginForm;
import workshop.config.security.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import workshop.service.UserService;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenBuilder jwtTokenBuilder;

    public Map createToken(LoginForm loginForm) {
        log.info("Generating token for user {}", loginForm.getLogin());
        final User user = userService.findByUserNameAndPlainTextPassword(loginForm.getLogin(), loginForm.getPassword())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        log.info("Token successfully generated for user {}", loginForm.getLogin());
        String token = jwtTokenBuilder.createToken(user);
        return Map.of("userName", user.getUserName(), "token", token);
    }

    public Long getUserId() {
        return null;
    }

    public boolean hasAuthGivenPartnerUid(UserAuthentication authentication, String partnerUid) {
        return authentication.getEmployeeUid().equals(partnerUid);
    }
}
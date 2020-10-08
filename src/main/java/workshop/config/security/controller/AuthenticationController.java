package workshop.config.security.controller;

import workshop.config.security.Service.AuthenticationService;
import workshop.config.security.dto.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public Map createToken(@RequestBody @Validated LoginForm loginForm) {
        return authenticationService.createToken(loginForm);
    }

}

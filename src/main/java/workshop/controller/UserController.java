package workshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.service.UserService;
import workshop.config.security.dto.RegisterForm;
import workshop.config.security.entity.User;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public User getAuthentication(@RequestBody @Validated RegisterForm registerForm) {
        return userService.createNewUser(registerForm);
    }

    @GetMapping("/{userName}")
    public User getAuthentication(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}

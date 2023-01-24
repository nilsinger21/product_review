package prs.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prs.user.User;
import prs.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class SignupController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignupController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @PostMapping("/signin")
    public User signin(@RequestBody User user) {
        User foundUser = userService.findByEmail(user.getEmail());
        if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            return foundUser;
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }
}

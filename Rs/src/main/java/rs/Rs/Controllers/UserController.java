package rs.Rs.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.Rs.models.User;
import rs.Rs.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody User loginRequest) {
		return userService.login(loginRequest.getUsername(), loginRequest.getPassword());
	}

	@PutMapping("/{id}")
	public User editProfile(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		return userService.editProfile(user);
	}

// other methods
}
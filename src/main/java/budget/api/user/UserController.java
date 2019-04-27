package budget.api.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import budget.api.PasswordMismatchException;
import budget.api.ResourceNotFoundException;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> user = userService.getUser(id);
		if (!user.isPresent())
			throw new ResourceNotFoundException("User not found.");
		return user;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users/login")
	@ResponseBody
	public Long loginCheck(@RequestBody Map<String, String> requestBody) {
		String userName = requestBody.get("username");
		String password = requestBody.get("password");
		User tempUser = userService.findByUsername(userName);
		if (tempUser == null)
			throw new ResourceNotFoundException("Username not found.");
		if (password.compareTo(tempUser.getPassword()) == 0) {
			return tempUser.getUserId();
		} else
			throw new PasswordMismatchException("Password incorrect.");
	}
}

package budget.api.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(10);

	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		userService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		user.setPassword(bCrypt.encode(user.getPassword()));
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
		if (bCrypt.matches(password, tempUser.getPassword())) {
			return tempUser.getUserId();
		} else
			throw new PasswordMismatchException("Password incorrect.");
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}/update")
	@ResponseBody
	public Map<String, String> updateInfo(@RequestBody Map<String, String> requestBody, @PathVariable Long id) {
		if (requestBody.containsKey("firstName")) {
			userService.updateInfo(id, "firstName", requestBody.get("firstName"));
		}
		if (requestBody.containsKey("lastName")) {
			userService.updateInfo(id, "lastName", requestBody.get("lastName"));
		}
		if (requestBody.containsKey("email")) {
			userService.updateInfo(id, "email", requestBody.get("email"));
		}
		if (requestBody.containsKey("password")) {
			userService.updateInfo(id, "password", bCrypt.encode(requestBody.get("password")));
			requestBody.replace("password", "Saved Successfully");
		}
		return requestBody;
	}
	
    @PostMapping("/users/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        userService.addUser(user);
    }
    
	@PostMapping("/users/me")
	public Long getUserIdByUserName(@RequestBody Map<String,String> requestBody) {
		String userName = requestBody.get("userName");
		User user = userService.findByUsername(userName);
		return user.getUserId();
	}
    
}

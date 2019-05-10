/*
 * File: UserController.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class maps URL requests JSON data to the appropriate user service and generates JSON responses
 */

package budget.api.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import budget.api.PasswordMismatchException;
import budget.api.ResourceNotFoundException;

@CrossOrigin(origins = "*") // allow cross origin from any domain
@RestController // annotate this class as a Spring RESTful api controller
public class UserController {

	// declare and initialize local variables
	private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(10);

	@Autowired
	private UserService userService;

	// This method maps Get requests to userService.getAllUsers().
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}// end method getAllUsers

	// This method maps Get requests to userService.getUser(id).
	@RequestMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> user = userService.getUser(id);
		if (!user.isPresent())
			throw new ResourceNotFoundException("User not found.");
		return user;
	}// end method getUser

	// This method maps Post requests to userService.addUser(user).
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		userService.addUser(user);
	}// end method addUser

	// This method maps Put requests to userService.addUser(user).
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		userService.updateUser(id, user);
	}// end method updateUser

	// This method maps Delete requests to userService.deleteUser(id)
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}// end method deleteUser

	// This method finds user in database, then compares request password with
	// database password, returning userId in response if pass.
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
	}// end method loginCheck

	// This method parses through Put request, sending individual field value
	// updates to userService.updateInfo(String updateValue).
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
	}// end method updateInfo
}// end class UserController

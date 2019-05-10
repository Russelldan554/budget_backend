/*
 * File: UserService.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class contains the methods which manipulate users in the user repository
 */

package budget.api.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // annotate this class as a Spring service
public class UserService {

	// declare local variables
	@Autowired
	private UserRepository userRepository;

	// This method returns a list of all users from the userRepository.
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}// end method getAllUsers

	// This method returns a specific user by userId from the userRepository.
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}// end method getUser

	// This method saves a user to the userRepository.
	public void addUser(User user) {
		userRepository.save(user);
	}// end method addUser

	// This method replaces the user in userRepository, with user passed-in.
	public void updateUser(Long id, User user) {
		userRepository.save(user);
	}// end method updateUser

	// This method deletes the user in userRepository.
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}// end method deleteUser

	// This method returns a specific user by username from the userRepository.
	public User findByUsername(String userName) {
		return userRepository.findByuserName(userName);
	}// end method findByUsername

	// This method retrieves the user in userRepository, then updates the field
	// values that were passed-in.
	public void updateInfo(Long id, String key, String value) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			User tempUser = user.get();
			switch (key) {
			case ("firstName"):
				tempUser.setFirstName(value);
			case ("lastName"):
				tempUser.setLastName(value);
			case ("email"):
				tempUser.setEmail(value);
			case ("password"):
				tempUser.setPassword(value);
			default:
			}
			userRepository.save(tempUser);
		}
	}// end method updateInfo
}// end class UserService

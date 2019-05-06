package budget.api.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import budget.api.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	@PostAuthorize("returnObject.userName == authentication.name")
	public User getUser(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		if (!optUser.isPresent())
			throw new ResourceNotFoundException("User not found.");
		User user = optUser.get();
		return user;
	}
	
	//@PreAuthorize("#username == application.principal.user.userName")
	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(Long id, User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@PostAuthorize("returnObject.userName == authentication.name")
	public User findByUsername(String userName) {
		return userRepository.findByuserName(userName);
	}

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
	}
}

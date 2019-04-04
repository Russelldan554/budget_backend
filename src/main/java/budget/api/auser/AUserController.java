package budget.api.auser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AUserController {
    
	@Autowired
	private AUserService aUserService;
	
	@RequestMapping("/ausers")
	public List<AUser> getAllUsers() {
		return aUserService.getAllUsers();
	}
	
	@RequestMapping("/ausers/{userId}")
	public Optional<AUser> getUser(@PathVariable long userId) {
		return aUserService.getUser(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/ausers")
	public void addUser(@RequestBody AUser auser) {
		aUserService.addUser(auser);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/ausers/{userId}")
	public void updateUser(@RequestBody AUser auser, @PathVariable long userId) {
		aUserService.updateUser(userId, auser);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/ausers/{userId}")
	public void deleteUser(@PathVariable long userId) {
		aUserService.deleteUser(userId);
	}
}

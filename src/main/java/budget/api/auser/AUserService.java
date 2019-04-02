package budget.api.auser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AUserService {

	@Autowired
	private AUserRepository aUserRepository;

	public List<AUser> getAllUsers() {
		List<AUser> ausers = new ArrayList<>();
		aUserRepository.findAll().forEach(ausers::add);
		return ausers;
	}

	public Optional<AUser> getUser(String userId) {
		return aUserRepository.findById(userId);
	}

	public void addUser(AUser auser) {
		aUserRepository.save(auser);
	}

	public void updateUser(String userId, AUser auser) {
		aUserRepository.save(auser);
	}

	public void deleteUser(String userId) {
		aUserRepository.deleteById(userId);
	}
}

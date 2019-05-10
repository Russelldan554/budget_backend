/*
 * File: UserRepository.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class manipulates users in the database
 */

package budget.api.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	// method from User repository that retrieves the user with a specific username
	public User findByuserName(String username);
}// end interface UserRepository

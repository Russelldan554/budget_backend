/*
 * File: User.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class serves as the structure for user objects and user table in the database
 */

package budget.api.user;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity // annotate this class as one which Spring will build a table in database for
public class User {

	// declare local variables and set database attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique = true, nullable = false, length = 20)
	private String userName;
	@Column(nullable = false, length = 30)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, length = 20)
	private String firstName;
	@Column(nullable = false, length = 20)
	private String lastName;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-DD")
	private Date dateCreated;

	// constructor
	public User(Long userId, String userName, String email, String password, String firstName, String lastName,
			Date dateCreated) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = dateCreated;
	}// end constructor

	// default constructor
	public User() {

	}// end default constructor

	// method to get the user Id
	public Long getUserId() {
		return userId;
	}// end method getUserId

	// method to set the user Id
	public void setUserId(Long id) {
		this.userId = id;
	}// end method setUserId

	// method to get the user username
	public String getUserName() {
		return userName;
	}// end method getUserName

	// method to set the user username
	public void setUserName(String userName) {
		this.userName = userName;
	}// end method setUserName

	// method to get the user email address
	public String getEmail() {
		return email;
	}// end method getEmail

	// method to set the user email address
	public void setEmail(String email) {
		this.email = email;
	}// end method setEmail

	// method to get the user password
	@JsonIgnore // ignore the getPassword method in JSON responses
	@JsonProperty(value = "password") // annotate this as the ignored property in JSON responses
	public String getPassword() {
		return password;
	}// end method getPassword

	// method to set the user password
	public void setPassword(String password) {
		this.password = password;
	}// end method setPassword

	// method to get the user first name
	public String getFirstName() {
		return firstName;
	}// end method getFirstName

	// method to set the user first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}// end method setFirstName

	// method to get the user last name
	public String getLastName() {
		return lastName;
	}// end method getLastName

	// method to set the user last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}// end method setLastName

	// method to get the date this user was created
	public Date getDateCreated() {
		return dateCreated;
	}// end method getDateCreated

	// method to set the date this user was created
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}// end method setDateCreated
}// end class User

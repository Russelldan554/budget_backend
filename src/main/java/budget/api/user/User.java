package budget.api.user;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(unique=true, nullable=false, length=20)
	private String userName;
	@Column(nullable=false, length=30)
	private String email;
	@Column(nullable=false, length=20)
	private String password;
	@Column(nullable=false, length=20)
	private String firstName;
	@Column(nullable=false, length=20)
	private String lastName;
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy-MM-DD")
	private Date dateCreated;
		
	public User(Long userId, String userName, String email, String password, String firstName, String lastName, Date dateCreated) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateCreated = dateCreated;
	}
	
	public User() {
		
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long id) {
		this.userId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}

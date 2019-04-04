package budget.api.auser;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "Users")
@EntityListeners(AuditingEntityListener.class)
public class AUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID", nullable=false, length=20)
	private Long userId;
	@Column(name="AccountID", nullable=false, length=20)
	private String accountId;
	@Column(name="User_Name", nullable=true, unique=true, length=20)
	private String userName;
	@Column(name="Password", nullable=false, length=20)
	private String password;
		
	public AUser(Long userId, String accountId, String userName, String password) {
		super();
		this.accountId = accountId;
		this.userName = userName;
		this.password = password;
	}
	
	public AUser() {
	
			}
		
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

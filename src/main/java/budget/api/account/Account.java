package budget.api.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import budget.api.user.User;

@Entity
public class Account {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long accountId;
	private String accountName;
	private Double balance;
	@ManyToOne
	private User user;
		
	public Account(Long accountId, String accountName, Double balance, Long userId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.user = new User(userId, "", "","","","",null);
	}
	
	public Account() {
		
	}
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

/*
 * File: Account.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class serves as the structure for account objects and account table in the database
 */

package budget.api.account;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import budget.api.user.User;

@Entity // annotate this class as one which Spring will build a table in database for
public class Account {

	// declare local variables and set database attributes and relationships
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(nullable = false, length = 30)
	private String accountName;
	@Column(nullable = false, length = 30)
	private String accountType;
	@Column(nullable = false, length = 30)
	private String bankName;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal balance;
	@ManyToOne
	private User user;

	// constructor
	public Account(Long accountId, String accountName, String accountType, String bankName, BigDecimal balance,
			Long userId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountType = accountType;
		this.bankName = bankName;
		this.balance = balance;
		this.user = new User(userId, "", "", "", "", "", null);
	}// end constructor

	// default constructor
	public Account() {

	}// end default constructor

	// method to get the account Id
	public Long getAccountId() {
		return accountId;
	}// end method getAccountId

	// method to set the account Id
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}// end method setAccountId

	// method to get the account name
	public String getAccountName() {
		return accountName;
	}// end method getAccountName

	// method to set the account name
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}// end method setAccountName

	// method to set the account name
	public String getAccountType() {
		return accountType;
	}// end method getAccountType

	// method to set the account type
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}// end method setAccountType

	// method to get the bank name
	public String getBankName() {
		return bankName;
	}// end method getBankName

	// method to set the bank name
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}// end method setBankName

	// method to get the balance
	public BigDecimal getBalance() {
		return balance;
	}// end method getBalance

	// method to set the balance
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}// end method setBalance

	// method to get the user attached to this account
	@JsonIgnore // ignore the getUser method in JSON responses
	@JsonProperty(value = "user") // annotate this as the ignored property in JSON responses
	public User getUser() {
		return user;
	}// end method getUser

	// method to set the user attached to this account
	public void setUser(User user) {
		this.user = user;
	}// end method setUser
}// end class Account

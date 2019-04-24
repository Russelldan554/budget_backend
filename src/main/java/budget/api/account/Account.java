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

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	@Column(nullable = false, length = 30)
	private String accountName;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal balance;
	@ManyToOne
	private User user;

	public Account(Long accountId, String accountName, BigDecimal balance, Long userId) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.balance = balance;
		this.user = new User(userId, "", "", "", "", "", null);
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

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@JsonIgnore
	@JsonProperty(value = "user")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

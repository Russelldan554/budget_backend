package budget.api.transaction;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import budget.api.account.Account;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@Column(nullable = false, length = 40)
	private String name;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-DD")
	private Date date;
	@Column(nullable = false, length = 40)
	private String category;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;
	@Column
	private Long userId;
	@ManyToOne
	private Account account;

	public Transaction(Long transactionId, String name, Date date, String category, BigDecimal amount, Long accountId) {
		super();
		this.transactionId = transactionId;
		this.name = name;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.account = new Account(accountId, "", "", "", null, null);
	}

	public Transaction() {

	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

//	@JsonIgnore
//	@JsonProperty(value = "account")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

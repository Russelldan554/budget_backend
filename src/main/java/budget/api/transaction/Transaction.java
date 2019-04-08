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
import budget.api.account.Account;


@Entity
public class Transaction {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy-MM-DD")
	private Date date;
	@Column(nullable=false, length=10)
	private String category;
	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal amount;
	@ManyToOne
	private Account account;
		
	public Transaction(Long transactionId, Date date, String category, BigDecimal amount, Long accountId) {
		super();
		this.transactionId = transactionId;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.account = new Account(accountId, "", null, null);
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}

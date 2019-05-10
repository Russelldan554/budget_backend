/*
 * File: Transaction.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class serves as the structure for transaction objects and transaction table in the database
 */

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

@Entity // annotate this class as one which Spring will build a table in database for
public class Transaction {

	// declare local variables and set database attributes and relationships
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // set auto-increment
	private Long transactionId;
	@Column(nullable = false, length = 40)
	private String name;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@Column(nullable = false, length = 40)
	private String category;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal amount;
	@Column
	private Long userId;
	@ManyToOne
	private Account account;

	// constructor
	public Transaction(Long transactionId, String name, Date date, String category, BigDecimal amount, Long accountId) {
		super();
		this.transactionId = transactionId;
		this.name = name;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.account = new Account(accountId, "", "", "", null, null);
	}// end constructor

	// default constructor
	public Transaction() {

	}// end default constructor

	// method to get the transaction Id
	public Long getTransactionId() {
		return transactionId;
	}// end method getTransactionId

	// method to set the transaction Id
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}// end method setTransactionId

	// method to get the date of transaction
	public Date getDate() {
		return date;
	}// end method getDate

	// method to set the date of transaction
	public void setDate(Date date) {
		this.date = date;
	}// end method setDate

	// method to get the transaction category
	public String getCategory() {
		return category;
	}// end method getCategory

	// method to set the transaction category
	public void setCategory(String category) {
		this.category = category;
	}// end method setCategory

	// method to get the transaction amount
	public BigDecimal getAmount() {
		return amount;
	}// end method getAmount

	// method to set the transaction amount
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}// end method setAmount

	// method to get the account attached to this transaction
//	@JsonIgnore // uncomment to ignore the getUser method in JSON responses
//	@JsonProperty(value = "account") // uncomment to annotate this as the ignored property in JSON responses
	public Account getAccount() {
		return account;
	}// end method getAccount

	// method to set the account attached to this transaction
	public void setAccount(Account account) {
		this.account = account;
	}// end method setAccount

	// method to get the userId associated with this transaction
	public Long getUserId() {
		return userId;
	}// end method getUserId

	// method to set the userId associated with this transaction
	public void setUserId(Long userId) {
		this.userId = userId;
	}// end method setUserId

	// method to get the transaction name
	public String getName() {
		return name;
	}// end method getName

	// method to set the transaction name
	public void setName(String name) {
		this.name = name;
	}// end method setName
}// end class Transaction

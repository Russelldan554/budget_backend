/*
 * File: Budget.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class serves as the structure for budget objects and budget table in the database
 */

package budget.api.budget;

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
public class Budget {

	// declare local variables and set database attributes and relationships
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long budgetId;
	@Column(nullable = false, length = 10)
	private String category;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal spentAmount;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal maxAmount;
	@ManyToOne
	private User user;

	// constructor
	public Budget(Long budgetId, String category, BigDecimal spentAmount, BigDecimal maxAmount, Long userId) {
		super();
		this.budgetId = budgetId;
		this.category = category;
		this.spentAmount = spentAmount;
		this.maxAmount = maxAmount;
		this.user = new User(userId, "", "", "", "", "", null);
	}// end constructor

	// default constructor
	public Budget() {

	}// end default constructor

	// method to get the budget Id
	public Long getBudgetId() {
		return budgetId;
	}// end method getBudgetId

	// method to set the budget Id
	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}// end method setBudgetId

	// method to get the budget category
	public String getCategory() {
		return category;
	}// end method getCategory

	// method to set the budget category
	public void setCategory(String category) {
		this.category = category;
	}// end method setCategory

	// method to get the budget amount spent
	public BigDecimal getSpentAmount() {
		return spentAmount;
	}// end method getSpentAmount

	// method to set the budget amount spent
	public void setSpentAmount(BigDecimal spentAmount) {
		this.spentAmount = spentAmount;
	}// end method setSpentAmount

	// method to get the budget maximum amount
	public BigDecimal getMaxAmount() {
		return maxAmount;
	}// end method getMaxAmount

	// method to set the budget maximum amount
	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}// end method setMaxAmount

	// method to get the user attached to this budget
	@JsonIgnore // ignore the getUser method in JSON responses
	@JsonProperty(value = "user") // annotate this as the ignored property in JSON responses
	public User getUser() {
		return user;
	}// end method getUser

	// method to set the user attached to this budget
	public void setUser(User user) {
		this.user = user;
	}// end method setUser
}// end class Budget

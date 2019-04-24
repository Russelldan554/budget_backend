package budget.api.budget;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import budget.api.user.User;

@Entity
public class Budget {

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

	public Budget(Long budgetId, String category, BigDecimal spentAmount, BigDecimal maxAmount, Long userId) {
		super();
		this.budgetId = budgetId;
		this.category = category;
		this.spentAmount = spentAmount;
		this.maxAmount = maxAmount;
		this.user = new User(userId, "", "", "", "", "", null);
	}

	public Budget() {

	}

	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getSpentAmount() {
		return spentAmount;
	}

	public void setSpentAmount(BigDecimal spentAmount) {
		this.spentAmount = spentAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}

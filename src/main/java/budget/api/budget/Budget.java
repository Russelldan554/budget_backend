package budget.api.budget;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import budget.api.user.User;

@Entity
public class Budget {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long budgetId;
	private String category;
	private Double maxAmount;
	@ManyToOne
	private User user;
		
	public Budget(Long budgetId, String category, Double maxAmount, Long userId) {
		super();
		this.budgetId = budgetId;
		this.category = category;
		this.maxAmount = maxAmount;
		this.user = new User(userId, "", "","","","",null);
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
	public Double getMaxAmount() {
		return maxAmount;
	}
	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}


package budget.api.category;

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
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@Column(nullable = false, length = 40)
	private String name;
	@ManyToOne
	private User user;

	public Category(Long categoryId, String name, Long userId) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.user = new User(userId, "", "", "", "", "", null);
	}

	public Category() {

	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

/*
 * File: Category.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class serves as the structure for category objects and category table in the database
 */

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

@Entity // annotate this class as one which Spring will build a table in database for
public class Category {

	// declare local variables and set database attributes and relationships
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@Column(nullable = false, length = 10)
	private String name;
	@ManyToOne
	private User user;

	// constructor
	public Category(Long categoryId, String name, Long userId) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.user = new User(userId, "", "", "", "", "", null);
	}// end constructor

	// default constructor
	public Category() {

	}// end default constructor

	// method to get the category Id
	public Long getCategoryId() {
		return categoryId;
	}// end method getCategoryId

	// method to set the category Id
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}// end method setCategoryId

	// method to get the category name
	public String getName() {
		return name;
	}// end method getName

	// method to set the category name
	public void setName(String name) {
		this.name = name;
	}// end method setName

	// method to get the user attached to this category
	@JsonIgnore // ignore the getUser method in JSON responses
	@JsonProperty(value = "user") // annotate this as the ignored property in JSON responses
	public User getUser() {
		return user;
	}// end method getUser

	// method to set the user attached to this category
	public void setUser(User user) {
		this.user = user;
	}// end method setUser
}// end class Category

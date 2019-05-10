/*
 * File: BudgetApiAppApplication.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class that contains the main method for the app
 */

package budget.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//designate this as the app's main Spring class, disable Spring's auto security configuration
@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class })
public class BudgetApiAppApplication {

	// Starts the application's main thread
	public static void main(String[] args) {
		SpringApplication.run(BudgetApiAppApplication.class, args);
	}// end method main
}// end class BudgetApiApplication

/*
 * File: ErrorDetails.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This class serves as the structure for error details in error responses
 */

package budget.api;

import java.util.Date;

public class ErrorDetails {
	
	//declare local variables
	private Date timestamp;
	private String message;
	private String details;

	//constructor
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.setTimestamp(timestamp);
		this.setMessage(message);
		this.setDetails(details);
	}//end constructor

	//method to return the time stamp
	public Date getTimestamp() {
		return timestamp;
	}//end method getTimestamp

	//method to set the time stamp
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}//end method setTimestamp

	//method to get the message
	public String getMessage() {
		return message;
	}//end method getMessage

	//method to set the message
	public void setMessage(String message) {
		this.message = message;
	}//end method setMessage

	//method to get the details
	public String getDetails() {
		return details;
	}//end method getDetails

	//method to set the details
	public void setDetails(String details) {
		this.details = details;
	}//end method setDetails
	
}//end class ErrorDetails
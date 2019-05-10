/*
 * File: PasswordMismatchException.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class extends RuntimeException and serves as the custom exception for mismatched passwords
 */

package budget.api;

public class PasswordMismatchException extends RuntimeException {

	/**
	* 
	*/
	// unique identifier for serialized class used with deserialization
	private static final long serialVersionUID = 1L;

	// constructor
	public PasswordMismatchException(String exception) {
		super(exception);
	}// end constructor

}// end class PasswordMismatchException

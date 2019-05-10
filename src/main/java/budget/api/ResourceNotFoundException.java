/*
 * File: ResourceNotFoundException.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class extends RuntimeException and serves as the custom exception when a resource is not found in database
 */

package budget.api;

public class ResourceNotFoundException extends RuntimeException {

	/**
	* 
	*/
	// unique identifier for serialized class used with deserialization
	private static final long serialVersionUID = 1L;

	// constructor
	public ResourceNotFoundException(String exception) {
		super(exception);
	}// end constructor

}// end class ResourceNotFoundException

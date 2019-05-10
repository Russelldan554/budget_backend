/*
 * File: CustomizedResponseEntityExceptionHandler.java
 * Author: Team Moolah, UMUC CMSC495 7980
 * Date: Spring 2019
 * Description: This is the class extends ResponseEntity and configurations for handling of certain exceptions
 */

package budget.api;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
//method to generate ErrorDetails when a ResourceNotFoundException is thrown and returns the ResponseEntity.
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}// end method handleUserNotFoundException

	// method to generate ErrorDetails when a PasswordMismatchException is thrown
	// and returns the ResponseEntity.
	@ExceptionHandler(PasswordMismatchException.class)
	public final ResponseEntity<ErrorDetails> handlePasswordMismatchException(PasswordMismatchException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}// end method handlePasswordMismatchException

	// method to generate ErrorDetails when a NullPointerException is thrown and
	// returns the ResponseEntity.
	@ExceptionHandler(NullPointerException.class)
	public final ResponseEntity<ErrorDetails> handleNullPointerException(NullPointerException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}// end method handleNullPointerException
}// end class CustomizedResponseEntityExceptionHandler

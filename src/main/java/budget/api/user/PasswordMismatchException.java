package budget.api.user;

public class PasswordMismatchException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException(String exception) {
		super(exception);
	}

}

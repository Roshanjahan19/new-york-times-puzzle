/**  
 * This class is the IllegalWordException of the word puzzle project.
 * This class extends IlegalArgumentException and have the constructor of the Word throw it.
 * @author Roshan Jahan
 */


public class IllegalWordException extends IllegalArgumentException {
	
	
	private static final long serialVersionUID = 1L;

	public IllegalWordException(String message) {
        super(message);
    }
	/**
     * Constructs an IllegalWordException with the specified detail message.
     * @param message the detail message
     */

}

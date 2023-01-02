package ds.fruit;

/**
 * This class is used to throw an exception when the fruit ripeness is invalid.
 * 
 */

//Create a custom exception class for Invalid Fruit Ripeness
public class InvalidFruitRipenessException extends Exception {

	// Declare a static final serialVersionUID field of type long
	private static final long serialVersionUID = 1L;

	// Declare String value for Exception message
	public InvalidFruitRipenessException(String message) {
		super("Ripeness cannot be below 0% nor above 100%" + message);
	}
}

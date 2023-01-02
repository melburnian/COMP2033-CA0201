package ds.fruit;

public class InvalidFruitWeightException extends Exception {

	// Add serialVersionUID
	private static final long serialVersionUID = 1L;

	// Create method to throw an exception
	public InvalidFruitWeightException(String message) {
		// Write message to be displayed to end user if exception called
		super("Weight cannot be below zero: " + message);
	}
}
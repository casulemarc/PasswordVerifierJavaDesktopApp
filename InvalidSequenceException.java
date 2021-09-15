
public class InvalidSequenceException extends Exception {
	
	public InvalidSequenceException() {
		System.out.println("The password cannot contain more than two of the same character in sequence.");
	}


}

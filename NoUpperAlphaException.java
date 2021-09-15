
public class NoUpperAlphaException extends Exception {
	
	public NoUpperAlphaException() {
		System.out.println("The password must contain at least one uppercase alphabetic character");
	}

}

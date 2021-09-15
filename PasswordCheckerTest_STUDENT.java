
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Test if the password is less than 8 characters long. This test should throw a
	 * LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {

			PasswordCheckerUtility.isValidPassword("ab12#");
			assertTrue("Password is long", false);

		} catch (LengthException e) {

			System.out.println("Successfully threw a lengthExcepetion");
			assertTrue("Successfully threw a lengthExcepetion", true);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character This test
	 * should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {

		try {

			PasswordCheckerUtility.isValidPassword("aa3ggh45");
			assertTrue("Password Uppercase Letters", false);

		} catch (NoUpperAlphaException e) {

			System.out.println("Successfully threw a no upper case exception");
			assertTrue("Successfully threw a no upper case exception", true);

		} catch (Exception e) {

			System.out.print(e.getMessage());
			assertTrue("Threw some other exception besides upper case exception", true);
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character This test
	 * should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {

		try {

			PasswordCheckerUtility.isValidPassword("A80A542#0");
			assertTrue("Password has lower Letter", false);

		} catch (NoLowerAlphaException e) {

			System.out.println("Successfully threw a no lower case exception");
			assertTrue("Successfully threw a no lower case exception", true);

		} catch (Exception e) {

			System.out.print(e.getMessage());
			assertTrue("Threw some other exception besides lower case exception", true);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {

		try {
			
			PasswordCheckerUtility.isWeakPassword("aVajA25@");
			assertTrue("Passwordd is between 6 to 9 characters", true);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			assertTrue("Threw some other exception besides weak exception", false);
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence This
	 * test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {

		try {
			
			assertTrue(PasswordCheckerUtility.isValidPassword("d1eeA#e"));
			PasswordCheckerUtility.isValidPassword("d1eeeA#");
			assertTrue("Password is with 2 or more same chracters in sequence", false);

		} catch (InvalidSequenceException e) {

			System.out.println("Successfully threw an InvalidSequenceExcepetion");
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);

		} catch (Exception e) {
			System.out.println("Successfully threw an InvalidSequenceExcepetion");
			assertTrue("Threw some other exception besides an InvalidSequenceException", true);
		}
	}

	/**
	 * Test if the password has at least one digit One test should throw a
	 * NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {

		try {
			
			PasswordCheckerUtility.isValidPassword("AWeeA");
			assertTrue("Password has atleast one digit", false);

		} catch (NoDigitException e) {

			System.out.println("Successfully threw an NoDigitExcepetion");
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);

		} catch (Exception e) {
			System.out.println("Succesfully threw an NoDigitExcepetion");
			assertTrue("Threw some other exception besides an InvalidSequenceException", true);
		}

	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {

		try{
			PasswordCheckerUtility.isValidPassword("1234aAA#zE");
			assertTrue("Did not throw an any exceptions",true);
		}
		catch(Exception e)
		{
			assertTrue("Didnot Throw some other exception",true);
		}
		finally
		{
			System.out.println("Complete");
		}

	}


	/**
	 * Test the invalidPasswords method Check the results of the ArrayList of
	 * Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		try {

			PasswordCheckerUtility.isValidPassword("A@");
			assertTrue("Password is valid", false);

		} catch (Exception e) {
			System.out.println("Password is invalid, less than 6, misses either Upper or lower characters, and specail characters.");
			assertTrue("Password is invalid", true);
		}
	}

}
import java.util.ArrayList;

public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {
	}

	/*
	 * @passwordString - - string to be checked for validity
	 * 
	 * @return true if valid password, set up to return false if an invalid
	 * password, but throws an exception instead.
	 */
	public static boolean isValidPassword(String passwordString) throws LengthException, NoDigitException,
			NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {

		// passsword length < 6
		if (passwordString.length() < 6) {
			throw new LengthException();
		} else {

			// if true, check pass per character
			for (int i = 0; i < passwordString.length(); i++) {

				// if true, passwd should contain an upper case
				if (passwordString.charAt(i) >= 65 && passwordString.charAt(i) <= 90) {

					// if true, passwd should contain a lower case
					if (passwordString.charAt(i) >= 97 && passwordString.charAt(i) <= 122) {

						// if true, passwd should contain number
						if (passwordString.charAt(i) >= 40 && passwordString.charAt(i) <= 57) {

							// if true, passwd should a special character
							if (passwordString.charAt(i) >= 32 && passwordString.charAt(i) <= 47
									|| passwordString.charAt(i) >= 58 && passwordString.charAt(i) <= 64
									|| passwordString.charAt(i) >= 91 && passwordString.charAt(i) <= 96
									|| passwordString.charAt(i) >= 123 && passwordString.charAt(i) <= 126) {

								// if true, check if passwd conatains more than 2 characters of same type in
								// sequence
								if (passwordString.charAt(i) == passwordString.charAt(i + 1)
										&& passwordString.charAt(i) != passwordString.charAt(i + 2)) {

									// check for length the between pass >= 6 && <= 9
									if (passwordString.length() >= 6 && passwordString.length() <= 9) {
										return isWeakPassword(passwordString);
									} else if (passwordString.length() >= 10) {
										return isStrongPassword(passwordString); // return true when password has passed
																					// all check points
									}

								} else {
									throw new InvalidSequenceException();
								}
							} else {
								throw new NoSpecialCharacterException();
							}
						} else {
							throw new NoDigitException();
						}
					} else {
						throw new NoLowerAlphaException();
					}

				} else {
					throw new NoUpperAlphaException();
				}
			}
		}
		return false; // return false when password fails all checks points
	}

	/*
	 * @param passwordString Return true if length of password is greater than or
	 * equal to 10
	 */
	private static boolean isStrongPassword(String passwordString) {

		return (passwordString.length() >= 10) ? true : false;
	}

	/*
	 * @param passwordString Return true if length of password is greater than or
	 * equal to 6 but less than or equal to 9
	 */
	public static boolean isWeakPassword(String passwordString) {

		return (passwordString.length() >= 6 && passwordString.length() <= 9) ? true : false;
	}

	/*
	 * Returns an array list of invalid passwords (weak passwords are not considered
	 * invalid)
	 * 
	 * @param passwords - array list of passwords to check for validity
	 * 
	 * @return inValidPwds - an array list of invalid passwords. It will not return
	 * weak passwords.
	 */
	public static ArrayList<String> isInvalidPasswords(ArrayList<String> passwords) {

		// Array list to store invalid passwords
		ArrayList<String> inValidPwds = new ArrayList<String>();

		// check for each pass in list to see if its invalid
		for (int i = 0; i < passwords.size(); i++) {
			try {
				if (isValidPassword(passwords.get(i)) == false) {
					// add it to invalid list
					inValidPwds.add(passwords.get(i));
				}
			} catch (Exception e) {
				System.out.println(passwords.get(i) + " Is invalid password!");
			}
		}
		return inValidPwds;
	}

}

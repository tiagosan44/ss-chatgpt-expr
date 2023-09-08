package com.softserve.chatgptregexpressions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatgptRegExpressionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatgptRegExpressionsApplication.class, args);
		// Test cases
		System.out.println(validateString("Ab1!", 10));  // True
		System.out.println(validateString("Ab1!", 3));   // False (too short)
		System.out.println(validateString("Ab1!", 4));   // True
		System.out.println(validateString("abc", 10));   // False (missing requirements)
		System.out.println(validateString("ABC123!abc", 10)); // True
		System.out.println(validateString("ABC 123!abc", 11)); // False (whitespace)
		System.out.println(validateString("ABC123!abc", 9));  // False (too long)
		System.out.println(validateString("", 10));   // False (too short)
		System.out.println(validateString("Aa1#", 10)); // True
		System.out.println(validateString("A1!", 10));  // False (missing lowercase)
	}

	/**
	 * Validate the string based on the requirements:
	 * - Maximum length is determined by the parameter maxLength.
	 * - At least one uppercase letter, one lowercase letter, one digit, and one special character.
	 * - No whitespace allowed.
	 *
	 * The regular expression is divided into four main parts:
	 * 1. `^(?=.*[A-Z])`: Positive lookahead to check for at least one uppercase letter.
	 * 2. `(?=.*[a-z])`: Positive lookahead to check for at least one lowercase letter.
	 * 3. `(?=.*\\d)`: Positive lookahead to check for at least one digit.
	 * 4. `(?=.*[!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~])`: Positive lookahead to check for at least one special character.
	 * 5. `[\\S]{1,maxLength}$`: Checks for non-whitespace characters and also sets the maximum length.
	 *
	 * @param str The string to be validated.
	 * @param maxLength The maximum allowable length for the string.
	 * @return True if the string is valid, otherwise false.
	 */
	public static boolean validateString(String str, int maxLength) {
		String regex = String.format(
			"^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!\"#$%%&'()*+,-./:;<=>?@[\\]^_`{|}~])[\\S]{1,%d}$",
			maxLength
		);

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}

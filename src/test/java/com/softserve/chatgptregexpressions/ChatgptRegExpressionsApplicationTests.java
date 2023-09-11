package com.softserve.chatgptregexpressions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ChatgptRegExpressionsApplicationTests {

	@Test
	void
	contextLoads() {
	}

	@Test
	public void testTooShortInput() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("A1!", 4));
	}

	@Test
	public void testTooLongInput() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("Abc123456!", 8));
	}

	@Test
	public void testMatchingInputLength() {
		assertTrue(ChatgptRegExpressionsApplication.validateString("A1b!", 4));
	}

	@Test
	public void testMissingUppercase() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("abc!1", 10));
	}

	@Test
	public void testMissingLowercase() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("ABC!1", 10));
	}

	@Test
	public void testMissingDigit() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("Abc!", 10));
	}

	@Test
	public void testMissingSpecialCharacter() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("Abc1", 10));
	}

	@Test
	public void testExcessWhitespaceAtStart() {
		assertFalse(ChatgptRegExpressionsApplication.validateString(" Abc1!", 10));
	}

	@Test
	public void testExcessWhitespaceAtEnd() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("Abc1! ", 10));
	}

	@Test
	public void testExcessWhitespaceInMiddle() {
		assertFalse(ChatgptRegExpressionsApplication.validateString("Abc 1!", 10));
	}

	@Test
	public void testValidString() {
		assertTrue(ChatgptRegExpressionsApplication.validateString("A1b!", 10));
	}
}

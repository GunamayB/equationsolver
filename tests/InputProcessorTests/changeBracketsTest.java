package tests.InputProcessorTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import input.InputProcessor;

class changeBracketsTest{

	@Test
	void test1() {
		InputProcessor inputHandler = InputProcessor.getInstance();
		String input="{[x+1]}";
		String result = inputHandler.changeBrackets(input);
		assertEquals("((x+1))", result);
	}

	@Test
	void test2() {
		InputProcessor inputHandler = InputProcessor.getInstance();
		String input="";
		String result = inputHandler.changeBrackets(input);
		assertEquals("", result);
	}
}


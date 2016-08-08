package stack;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for MyStack.java
 * @author Tony Song
 *
 */

public class TestMyStack {
	private MyStack<String> emptyStack;
	private MyStack<String> strStack;
	private MyStack<Integer> intStack;
	private MyStack<Boolean> boolStack;
	
	@Before
	public void setup() {
		emptyStack = new MyStack<>();
		strStack = new MyStack<>();
		intStack = new MyStack<>();
		boolStack = new MyStack<>();
		
		strStack.push("One");
		strStack.push("Two");
		strStack.push("Three");
		intStack.push(10);
		intStack.push(20);
		intStack.push(30);
		intStack.push(40);
		boolStack.push(false);
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(emptyStack.isEmpty());
		assertFalse(strStack.isEmpty());
		assertFalse(intStack.isEmpty());
		assertFalse(boolStack.isEmpty());
	}
	
	@Test
	public void clearTest() {
		strStack.clear();
		boolStack.clear();
		
		assertTrue(emptyStack.isEmpty());
		assertTrue(strStack.isEmpty());
		assertFalse(intStack.isEmpty());
		assertTrue(boolStack.isEmpty());
	}
	
	@Test
	public void pushTest() {
		emptyStack.push("None");
		
		assertFalse(emptyStack.isEmpty());
	}
	
	@Test
	public void pushTest2() {
		emptyStack.push("None");
		strStack.push("newbie");
		intStack.push(-100);
		
		assertEquals("None", emptyStack.peek());
		assertEquals("newbie", strStack.pop());
		assertEquals(-100, (int) intStack.pop());
	}
	
	@Test
	public void popTest() {
		assertEquals("Three", strStack.pop());
		assertEquals("Two", strStack.pop());
		assertEquals("One", strStack.pop());
		assertEquals(40, (int) intStack.pop());
		assertEquals(30, (int) intStack.pop());
	}
	
	@Test
	public void peekTest() {
		assertEquals("Three", strStack.peek());
		assertEquals(40, (int) intStack.peek());
		assertEquals(false, boolStack.peek());
	}
	
	@Test(expected = EmptyStackException.class)
	public void peekFromEmptyExceptionTest() throws EmptyStackException {
		emptyStack.peek();
	}
	
	@Test(expected = EmptyStackException.class)
	public void popFromEmptyExceptionTest() throws EmptyStackException {
		emptyStack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void popFromEmptyExceptionTest2() throws EmptyStackException {
		strStack.pop();
		strStack.pop();
		strStack.pop();
		strStack.pop();
	}
	
	@Test(expected = EmptyStackException.class)
	public void popFromEmptyExceptionTest3() throws EmptyStackException {
		boolStack.pop();
		boolStack.pop();
	}
}

package queue;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for MyQueue.java.
 * @author Tony Song
 *
 */

public class TestMyQueue {
	private MyQueue<String> emptyQueue;
	private MyQueue<String> strQueue;
	private MyQueue<Integer> intQueue;
	private MyQueue<Boolean> boolQueue;
	
	@Before
	public void setup() {
		emptyQueue = new MyQueue<>();
		strQueue = new MyQueue<>();
		intQueue = new MyQueue<>();
		boolQueue = new MyQueue<>();
		
		strQueue.enqueue("One");
		strQueue.enqueue("Two");
		strQueue.enqueue("Three");
		intQueue.enqueue(10);
		intQueue.enqueue(20);
		intQueue.enqueue(30);
		intQueue.enqueue(40);
		boolQueue.enqueue(false);
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(emptyQueue.isEmpty());
		assertFalse(strQueue.isEmpty());
		assertFalse(intQueue.isEmpty());
		assertFalse(boolQueue.isEmpty());
	}
	
	@Test
	public void dequeueAllTest() {
		strQueue.dequeueAll();
		boolQueue.dequeueAll();
		
		assertTrue(emptyQueue.isEmpty());
		assertTrue(strQueue.isEmpty());
		assertFalse(intQueue.isEmpty());
		assertTrue(boolQueue.isEmpty());
	}
	
	@Test
	public void enqueueTest() {
		emptyQueue.enqueue("None");
		
		assertFalse(emptyQueue.isEmpty());
	}
	
	@Test
	public void enqueueTest2() {
		emptyQueue.enqueue("None");
		strQueue.enqueue("newbie");
		intQueue.enqueue(-100);
		
		assertEquals("None", emptyQueue.peek());
		assertEquals("One", strQueue.dequeue());
		assertEquals(10, (int) intQueue.dequeue());
	}
	
	@Test
	public void dequeueTest() {
		assertEquals("One", strQueue.dequeue());
		assertEquals("Two", strQueue.dequeue());
		assertEquals("Three", strQueue.dequeue());
		assertEquals(10, (int) intQueue.dequeue());
		assertEquals(20, (int) intQueue.dequeue());
	}
	
	@Test
	public void peekTest() {
		assertEquals("One", strQueue.peek());
		assertEquals(10, (int) intQueue.peek());
		assertEquals(false, boolQueue.peek());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void peekFromEmptyExceptionTest() throws NoSuchElementException {
		emptyQueue.peek();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void dequeueFromEmptyExceptionTest() throws NoSuchElementException {
		emptyQueue.dequeue();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void dequeueFromEmptyExceptionTest2() throws NoSuchElementException {
		strQueue.dequeue();
		strQueue.dequeue();
		strQueue.dequeue();
		strQueue.dequeue();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void dequeueFromEmptyExceptionTest3() throws NoSuchElementException {
		boolQueue.dequeue();
		boolQueue.dequeue();
	}
}

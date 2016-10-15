package queue;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Heap.java
 * @author Tony Song
 *
 */
public class TestHeap {
	private Heap<Integer> emptyHeap;
	private Heap<Integer> threeEHeap;
	private Heap<Integer> eightEHeap;
	
	@Before
	public void setup() {
		emptyHeap = new Heap<Integer>();
		threeEHeap = new Heap<Integer>(Arrays.asList(5, 3, 2));
		eightEHeap = new Heap<Integer>(Arrays.asList(10, 8, 17, 9, 6, 11, 7, 1));
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(emptyHeap.isEmpty());
		assertFalse(threeEHeap.isEmpty());
		assertFalse(eightEHeap.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		assertEquals(0, emptyHeap.size());
		assertEquals(3, threeEHeap.size());
		assertEquals(8, eightEHeap.size());
	}

	@Test
	public void addTest() {
		emptyHeap.add(1);
		
		assertFalse(emptyHeap.isEmpty());
		assertEquals(1, emptyHeap.size());
		assertEquals((Integer) 1, emptyHeap.peek());
	}
	
	@Test
	public void addTest2() {
		emptyHeap.add(1);
		emptyHeap.add(7);
		
		assertFalse(emptyHeap.isEmpty());
		assertEquals(2, emptyHeap.size());
		assertEquals((Integer) 1, emptyHeap.peek());
	}
	
	@Test
	public void addTest3() {
		eightEHeap.add(3);
		eightEHeap.add(2);
		
		assertFalse(eightEHeap.isEmpty());
		assertEquals(10, eightEHeap.size());
		assertEquals((Integer) 1, eightEHeap.peek());
	}

	@Test
	public void removeTest() {
		assertNull(emptyHeap.remove());
		assertEquals((Integer) 2, threeEHeap.remove());
		assertEquals((Integer) 3, threeEHeap.remove());
		assertEquals((Integer) 5, threeEHeap.remove());
		assertNull(threeEHeap.remove());
	}
	
	@Test
	public void removeTest2() {
		assertEquals((Integer) 1, eightEHeap.remove());
		assertEquals((Integer) 6, eightEHeap.remove());
		assertEquals((Integer) 7, eightEHeap.remove());
		assertEquals((Integer) 8, eightEHeap.remove());
		assertEquals((Integer) 9, eightEHeap.remove());
		assertEquals((Integer) 10, eightEHeap.remove());
		assertEquals((Integer) 11, eightEHeap.remove());
		assertEquals((Integer) 17, eightEHeap.remove());
	}
	
	@Test
	public void addRemoveTest() {
		emptyHeap.add(50);
		emptyHeap.add(9);
		emptyHeap.add(23);
		emptyHeap.add(7);
		emptyHeap.add(6);
		emptyHeap.add(19);
		emptyHeap.add(30);
		
		assertEquals((Integer) 6, emptyHeap.remove());
		assertEquals((Integer) 7, emptyHeap.remove());
		assertEquals((Integer) 9, emptyHeap.remove());
		assertEquals((Integer) 19, emptyHeap.remove());
		assertEquals((Integer) 23, emptyHeap.remove());
		assertEquals((Integer) 30, emptyHeap.remove());
		assertEquals((Integer) 50, emptyHeap.remove());
	}
	
	@Test
	public void peekTest() {
		assertNull(emptyHeap.peek());
		assertEquals((Integer) 2, threeEHeap.peek());
		assertEquals((Integer) 1, eightEHeap.peek());
	}
	
	@Test(expected = NullPointerException.class)
	public void addNullExceptionTest() throws NullPointerException {
		emptyHeap.add(null);
	}
}

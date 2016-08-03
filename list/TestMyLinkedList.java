package list;

/**
 * Unit tests for MyLinkedList.java
 * @author Tony Song
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyLinkedList {
	private MyLinkedList<Integer> emptyList;
	private MyLinkedList<Boolean> oneList;
	private MyLinkedList<Integer> intList;
	private MyLinkedList<String> strList;
	
	@Before
	public void setup() {
		emptyList = new MyLinkedList<>();
		oneList = new MyLinkedList<>();
		intList = new MyLinkedList<>();
		strList = new MyLinkedList<>();
		
		oneList.add(0, true);
		intList.add(0, 10);
		intList.add(1, 15);
		intList.add(2, 20);
		strList.add(0, "first");
		strList.add(1, "second");
		strList.add(2, "third");
		strList.add(3, "fourth");
	}
	
	@Test
	public void isEmptyTest() {
		assertTrue(emptyList.isEmpty());
		assertFalse(oneList.isEmpty());
		assertFalse(strList.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		assertEquals(0, emptyList.size());
		assertEquals(1, oneList.size());
		assertEquals(3, intList.size());
		assertEquals(4, strList.size());
	}
	
	@Test
	public void getTest() {
		assertEquals(true, (boolean)oneList.get(0));
		assertEquals("first", strList.get(0));
		assertEquals("second", strList.get(1));
		assertEquals("fourth", strList.get(3));
		assertEquals(20, (int)intList.get(2));
	}
	
	@Test
	public void addTest() {
		emptyList.add(0, 3);
		emptyList.add(1, 7);
		emptyList.add(0, 5);
		
		assertEquals(5, (int) emptyList.get(0));
		assertEquals(3, (int) emptyList.get(1));
		assertEquals(7, (int) emptyList.get(2));
		assertEquals(3, emptyList.size());
	}
	
	@Test
	public void clearTest() {
		emptyList.clear();
		intList.clear();
		strList.clear();
		
		assertTrue(emptyList.isEmpty());
		assertTrue(intList.isEmpty());
		assertTrue(strList.isEmpty());
		assertEquals(0, intList.size());
		assertEquals(0, strList.size());
	}
	
	@Test
	public void removeTest() {
		oneList.remove(0);
		intList.remove(1);
		
		assertTrue(oneList.isEmpty());
		assertEquals(0, oneList.size());
		assertEquals(2, intList.size());
		assertEquals(10, (int)intList.get(0));
		assertEquals(20, (int)intList.get(1));
	}
	
	@Test
	public void removeTest2() {
		strList.remove(0);
		strList.remove(2);
		
		assertEquals("second", strList.get(0));
		assertEquals("third", strList.get(1));
	}
	
	@Test
	public void iteratorTest() {
		String strResult = "";
		int intResult = 0;
		
		for (String s: strList) {
			strResult += s;
		}
		for (int n: intList) {
			intResult += n;
		}
		
		assertEquals("firstsecondthirdfourth", strResult);
		assertEquals(45, intResult);
	}
	
	@Test(expected = ListIndexOutOfBoundsException.class)
	public void getFromEmptyExceptionTest() throws ListIndexOutOfBoundsException {
		emptyList.get(0);
	}
	
	@Test(expected = ListIndexOutOfBoundsException.class)
	public void getFromOutBoundExceptionTest() throws ListIndexOutOfBoundsException {
		intList.get(3);
	}
	
	@Test(expected = ListIndexOutOfBoundsException.class)
	public void addOutBoundExceptionTest() throws ListIndexOutOfBoundsException {
		emptyList.add(1, 1);
	}
	
	@Test(expected = ListIndexOutOfBoundsException.class)
	public void removeOutBoundExceptionTest() throws ListIndexOutOfBoundsException {
		emptyList.remove(0);
	}
}

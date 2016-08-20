package bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for BinarySearchTree.java
 * @author Tony Song
 *
 */
public class TestBST {
	BinarySearchTree<Integer, Integer> emptyT;
	BinarySearchTree<Integer, Integer> rootFourH0;
	BinarySearchTree<Integer, Integer> leftH3;
	BinarySearchTree<Integer, Integer> rightH4;
	BinarySearchTree<Integer, Integer> leftH3rightH5;
	BinarySearchTree<Integer, Integer> complexH3;
	
	@Before
	public void setUp() {
		emptyT = new BinarySearchTree<>();
		rootFourH0 = new BinarySearchTree<>();
		leftH3 = new BinarySearchTree<>();
		rightH4 = new BinarySearchTree<>();
		leftH3rightH5 = new BinarySearchTree<>();
		/**
		 *        17
		 *      /    \
		 *     9     20
		 *   /  \
		 *  5    11
		 *   \   / 
		 *   7  10
		 */
		complexH3 = new BinarySearchTree<>();
		
		rootFourH0.insert(4, 4);
		
		for (int i = 4; i >= 1; i--) {
			leftH3.insert(i, i);
			leftH3rightH5.insert(i, i);
		}
		
		for (int i = 1; i <= 5; i++) {
			rightH4.insert(i, i);
			leftH3rightH5.insert(i + 4, i + 4);
		}
		
		complexH3.insert(17, 17);
		complexH3.insert(20, 20);
		complexH3.insert(9, 9);
		complexH3.insert(11, 11);
		complexH3.insert(5, 5);
		complexH3.insert(7, 7);
		complexH3.insert(10, 10);
	}

	@Test
	public void isEmptyTest() {
		assertTrue(emptyT.isEmpty());
		assertFalse(rootFourH0.isEmpty());
	}
	
	@Test
	public void sizeTest() {
		assertEquals(0, emptyT.size());
		assertEquals(1, rootFourH0.size());
	}
	
	@Test
	public void heightTest() {
		assertEquals(-1, emptyT.height());
		assertEquals(0, rootFourH0.height());
		assertEquals(3, leftH3.height());
	}
	
	@Test
	public void heightTest2() {
		assertEquals(4, rightH4.height());
		assertEquals(5, leftH3rightH5.height());
		assertEquals(3, complexH3.height());
	}
	
	@Test
	public void getTest() {
		assertNull(emptyT.get(1));
		assertNull(rootFourH0.get(1));
		assertEquals(4, (int) rootFourH0.get(4));
	}
	
	@Test
	public void insertTest() {
		emptyT.insert(7, 7);
		rootFourH0.insert(3, 3);
		rootFourH0.insert(5, 5);
		
		assertEquals(1, emptyT.size());
		assertEquals(3, rootFourH0.size());
		
		assertEquals(7, (int) emptyT.get(7));
		assertEquals(4, (int) rootFourH0.get(4));
		assertEquals(3, (int) rootFourH0.get(3));
		assertEquals(5, (int) rootFourH0.get(5));
	}
	
	@Test
	public void deleteTest() {
		rootFourH0.delete(4);
		
		assertTrue(rootFourH0.isEmpty());
		assertEquals(-1, rootFourH0.height());
	}
	
	@Test
	public void deleteTest2() {
		leftH3.delete(3);
		
		assertEquals(2, leftH3.height());
		assertEquals(4, (int) leftH3.get(4));
		assertEquals(2, (int) leftH3.get(2));
		assertEquals(1, (int) leftH3.get(1));
		assertNull(leftH3.get(3));
	}
	
	@Test
	public void deleteTest3() {
		complexH3.delete(9);
		
		assertEquals(4, complexH3.height());
		assertEquals(5, (int) complexH3.get(5));
		assertEquals(7, (int) complexH3.get(7));
		assertEquals(11, (int) complexH3.get(11));
		assertNull(complexH3.get(9));
	}
	
	@Test(expected = NullPointerException.class)
	public void getWithNullKey() throws NullPointerException {
		emptyT.get(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void getWithNullKey2() throws NullPointerException {
		rootFourH0.get(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void insertWithNullKey() throws NullPointerException {
		emptyT.insert(null, 1);
	}
	
	@Test(expected = NullPointerException.class)
	public void insertWithNullKey2() throws NullPointerException {
		rootFourH0.insert(null, 1);
	}
}

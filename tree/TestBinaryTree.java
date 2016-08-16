package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for BinaryTree.java
 * @author Tony Song
 *
 */
public class TestBinaryTree {
	private BinaryTree<Integer> emptyT;
	private BinaryTree<Integer> rootOneH0;
	private BinaryTree<Integer> rootFiveH0;
	private BinaryTree<Integer> rootSixH1;
	private BinaryTree<Integer> rootTwoH2;
	
	@Before
	public void setUp() {
		emptyT = new BinaryTree<>();
		rootOneH0 = new BinaryTree<>(1);
		rootFiveH0 = new BinaryTree<>(5);
		rootSixH1 = new BinaryTree<>(6, new BinaryTree<>(1), new BinaryTree<>(5));
		/*
		 *             2
		 *           /   \
		 *          6     4
		 *         / \   / \
		 *        1  5  10  8
		 */
		rootTwoH2 = new BinaryTree<>(2, 
									 new BinaryTree<>(6, new BinaryTree<>(1), new BinaryTree<>(5)),
									 new BinaryTree<>(4, new BinaryTree<>(10), new BinaryTree<>(8)));
	}

	@Test
	public void isEmptyTest() {
		assertTrue(emptyT.isEmpty());
		assertFalse(rootOneH0.isEmpty());
		assertFalse(rootSixH1.isEmpty());
		assertFalse(rootTwoH2.isEmpty());
	}
	
	@Test
	public void clearTest() {
		emptyT.clear();
		rootFiveH0.clear();
		rootSixH1.clear();
		rootTwoH2.clear();
		
		assertTrue(emptyT.isEmpty());
		assertTrue(rootFiveH0.isEmpty());
		assertTrue(rootSixH1.isEmpty());
		assertTrue(rootTwoH2.isEmpty());
	}
	
	@Test
	public void getRootItemTest() {
		assertEquals(1, (int) rootOneH0.getRootItem());
		assertEquals(5, (int) rootFiveH0.getRootItem());
		assertEquals(6, (int) rootSixH1.getRootItem());
		assertEquals(2, (int) rootTwoH2.getRootItem());
	}
	
	@Test
	public void setRootItemTest() {
		emptyT.setRootItem(0);
		rootOneH0.setRootItem(1);
		rootSixH1.setRootItem(2);
		rootTwoH2.setRootItem(3);
		
		assertEquals(0, (int) emptyT.getRootItem());
		assertEquals(1, (int) rootOneH0.getRootItem());
		assertEquals(2, (int) rootSixH1.getRootItem());
		assertEquals(3, (int) rootTwoH2.getRootItem());
	}
	
	@Test
	public void attachLeftTest() {
		rootOneH0.attachLeft(10);
		rootFiveH0.attachLeft(20);
		
		assertEquals(10, (int) rootOneH0.root.leftChild.item);
		assertEquals(20, (int) rootFiveH0.root.leftChild.item);
	}
	
	@Test
	public void attachRightTest() {
		rootOneH0.attachRight(10);
		rootFiveH0.attachRight(20);
		
		assertEquals(10, (int) rootOneH0.root.rightChild.item);
		assertEquals(20, (int) rootFiveH0.root.rightChild.item);
	}
	
	@Test
	public void attachLeftSubtreeTest() {
		rootOneH0.attachLeftSubtree(rootSixH1);
		
		assertEquals(1, (int) rootOneH0.root.item);
		assertEquals(6, (int) rootOneH0.root.leftChild.item);
		assertNull(rootOneH0.root.rightChild);
	}
	
	@Test
	public void attachRightSubtreeTest() {
		rootOneH0.attachRightSubtree(rootSixH1);
		
		assertEquals(1, (int) rootOneH0.root.item);
		assertEquals(6, (int) rootOneH0.root.rightChild.item);
		assertNull(rootOneH0.root.leftChild);
	}
	
	@Test
	public void detachLeftSubtreeTest() {
		BinaryTree<Integer> left = rootTwoH2.detachLeftSubtree();
		
		assertNull(rootTwoH2.root.leftChild);
		assertEquals(6, (int) left.root.item);
		assertEquals(1, (int) left.root.leftChild.item);
		assertEquals(5, (int) left.root.rightChild.item);
	}
	
	@Test
	public void detachRightSubtreeTest() {
		BinaryTree<Integer> right = rootTwoH2.detachRightSubtree();
		
		assertNull(rootTwoH2.root.rightChild);
		assertEquals(4, (int) right.root.item);
		assertEquals(10, (int) right.root.leftChild.item);
		assertEquals(8, (int) right.root.rightChild.item);
	}
}

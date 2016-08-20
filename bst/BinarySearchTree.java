package bst;

import java.util.NoSuchElementException;

/**
 * Implementation of ADT binary search tree
 * @author Tony Song
 *
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K extends Comparable<K>, V> {
	protected Node root;
	private int size = 0;
	
	/**
	 * Return true if the BST is empty.
	 * @return a boolean
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * Return the number of nodes in the BST.
	 * @return the number of nodes
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Remove all nodes from the BST.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Return the height of the BST. An empty BST's height is -1.
	 * @return height of the BST
	 */
	public int height() {
		return heightHelper(root, -1);
	}
	
	/**
	 * Recursive helper method to find the height of the current node.
	 * Return the greater value between the left subtree's height + 1
	 * and the right subtree's height + 1.
	 * @param current
	 * @param height
	 * @return height of the current node
	 */
	private int heightHelper(Node current, int height) {
		if (current == null) {
			return height;
		}
		
		int leftH = heightHelper(current.left, height + 1);
		int rightH = heightHelper(current.right, height + 1);
		
		return leftH < rightH ? rightH : leftH;
	}
	
	/**
	 * Insert a new node into a binary search tree whose nodes have 
	 * distinct search keys that differ from the given key.
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value) {
		if (key == null) {
			throw new NullPointerException("Null key");
		}
		
		if (isEmpty()) {
			root = new Node(key, value);
		} else {
			insertHelper(key, value, root);
		}
		
		size++;
	}
	
	/**
	 * Recursive helper method to find the right place and insert a new node 
	 * at that place.
	 * @param key
	 * @param value
	 * @param current
	 */
	private void insertHelper(K key, V value, Node current) {
		if (key.compareTo(current.key) < 0) {
			if (current.left == null) {
				current.left = new Node(key, value);
			} else {
				insertHelper(key, value, current.left);
			}
		} else {
			// key > current.key because duplicates are not allowed
			if (current.right == null) {
				current.right = new Node(key, value);
			} else {
				insertHelper(key, value, current.right);
			}
		}
	}
	
	/**
	 * Delete from a BST the node whose key is equal to the given key.
	 * If the given key is null, it throws NullPointerException. 
	 * If no such node exists, it throws NoSuchElementException.
	 * @param key
	 */
	public void delete(K key) {
		if (key == null) {
			throw new NullPointerException("Null key");
		}
		
		if (isEmpty()) {
			throw new NoSuchElementException("Cannot delete from an empty tree");
		} else if (key.equals(root.key)) {
			deleteNode(root, "root");
		} else {
			deleteHelper(key, root);
		}
		
		size--;
	}
	
	/**
	 * Recursive helper method to find the node with the given key and delete it.
	 * @param key
	 * @param current
	 */
	private void deleteHelper(K key, Node current) {
		if (key.compareTo(current.key) < 0) {
			if (current.left == null) {
				throw new NoSuchElementException("No such node with the given key");
			} else if (key.equals(current.left.key)) {
				deleteNode(current, "left");
			} else {
				// the left child's key is not equal to the given key
				deleteHelper(key, current.left);
			}
		} else {
			// key > current.key because duplicates are not allowed
			if (current.right == null) {
				throw new NoSuchElementException("No such node with the given key");
			} else if (key.equals(current.right.key)) {
				// delete the right node and restructure
				deleteNode(current, "right");
			} else {
				// the right child's key is not equal to the given key
				deleteHelper(key, current.right);
			}
		}
	}
	
	/**
	 * Helper method to delete the given child of the node and restructure the BST
	 * (the child's right subtree is attached to the right most node
	 * of the child's left subtree) 
	 * @param parent
	 * @param child - should be either "root", "left", or "right"
	 */
	private void deleteNode(Node parent, String child) {
		Node leftSubtree;
		Node rightSubtree;
		Node rightmost;
		
		if (child.equals("root")) {
			leftSubtree = parent.left;
			rightSubtree = parent.right;
			rightmost = rightmost(leftSubtree);
			
			if (rightmost == null) {
				root = rightSubtree;
			} else {
				root = leftSubtree;
				rightmost.right = rightSubtree;
			} 
		} else if (child.equals("left")) {
			leftSubtree = parent.left.left;
			rightSubtree = parent.left.right;
			rightmost = rightmost(leftSubtree);
			
			// if rightmost is null, just put rightSub to the position
			// otherwise put it on the right
			if (rightmost == null) {
				parent.left = rightSubtree;
			} else {
				parent.left = leftSubtree;
				rightmost.right = rightSubtree;
			}
			
		} else if (child.equals("right")) {
			leftSubtree = parent.right.left;
			rightSubtree = parent.right.right;
			rightmost = rightmost(leftSubtree);
			
			if (rightmost == null) {
				parent.right = rightSubtree;
			} else {
				parent.right = leftSubtree;
				rightmost.right = rightSubtree;
			}
			
		} else {
			throw new IllegalArgumentException("The child should be either \"root\" \"left\" or \"right\"");
		}
	}
	
	/**
	 * Return the rightmost leaf node of the given node. 
	 * If the node is null, it returns null.
	 * @param node
	 * @return the rightmost leaf node of the given node
	 */
	private Node rightmost(Node node) {
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node;
		} else {
			return rightmost(node.right);
		}
	}
	
	/**
	 * Return the value of the node whose key is equal to 
	 * the given key. Return null if no such node exists.
	 * Throw NullPointerException if the key is null.
	 * @param key
	 * @return value of the node with the given key
	 */
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException("Null key");
		}
		return getHelper(key, root);
	}
	
	/**
	 * Recursive helper method to find the node with the given key
	 * and return the node's value.
	 * @param key
	 * @param current
	 * @return value of the node with the given key
	 */
	private V getHelper(K key, Node current) {
		if (current == null) {
			// if there is no such node
			return null;
		} else if (key.equals(current.key)) {
			return current.value;
		} else if (key.compareTo(current.key) < 0) {
			return getHelper(key, current.left);
		} else {
			return getHelper(key, current.right);
		}
	}
	
	/**
	 * Inner class that represents a node in a BST
	 */
	private class Node {
		public K key;
		public V value;
		public Node left = null;
		public Node right = null;

		// null key will generate a null pointer exception when
		// a method (such as compareTo) is called on it.
		// This is fine, according to the JCF specification.
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}

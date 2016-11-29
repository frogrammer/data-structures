package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList implementation of ADT list
 * @author Tony Song
 *
 * @param <E>
 */

public class MyLinkedList<E> implements ListInterface<E>, Iterable<E> {
	private Node head = null;
	private int size = 0;
	
	@Override
	public boolean isEmpty() {
		// Time complexity: O(1)
		return head == null;
	}

	@Override
	public int size() {
		// Time complexity: O(1)
		// However, we need to keep track of the size for every insertion and deletion
		return size;
	}
	
	@Override
	public void add(int index, E item) {
		// Time complexity for insertion: O(1)
		// Assuming we already know where to insert
		if (index < 0 || index > size) {
			throw new ListIndexOutOfBoundsException();
		}
		
		if (index == 0) {
			// works correctly when the list is empty
			head = new Node(item, head); 
		} else {
			Node prev = find(index - 1);
			prev.next = new Node(item, prev.next);
		}
		size++;
	}

	@Override
	public void remove(int index) {
		// Time complexity for deletion: O(1)
		// Assuming we already know where to delete
		if (index < 0 || index >= size || head == null) {
			throw new ListIndexOutOfBoundsException();
		}
		
		if (index == 0) {
			head = head.next;
		} else {
			Node prev = find(index - 1);
			prev.next = prev.next.next;
		}
		size--;
	}

	@Override
	public E get(int index) {
		// Time complexity for access: O(n)
		if (index < 0 || index >= size || head == null) {
			throw new ListIndexOutOfBoundsException();
		}
		
		Node current = find(index);
		return current.item;
	}

	@Override
	public void clear() {
		// Time complexity: O(1)
		head = null;
		size = 0;	
	}
	
	@Override
	public String toString() {
		String toReturn = "";
		Node current = head;
		
		if (current == null) {
			return toReturn;
		}
		
		toReturn += "[" + head.item;
		
		while (current.next != null) {
			toReturn += ", ";
			current = current.next;
			toReturn += current.item;
		}
		
		return toReturn + "]";
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E> {
		private Node current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if (hasNext()) {
				E item = current.item;
				current = current.next;
				return item;
			} else {
				throw new NoSuchElementException();
			}
		}
	}
	
	
	/**
	 * An inner class that represents a node of the LinkedList
	 */
	private class Node {
		E item;
		Node next;
		
		Node(E element, Node next) {
			this.item = element;
			this.next = next;
		}
	}
	
	/**
	 * Take an index and return the Node object at the index.
	 * @param index
	 * @return the Node at the given index
	 * @throw ListIndexOutOfBoundsException 
	 */
	private Node find(int index) {
		// Time complexity for search: O(n)
		if (index < 0 || index > size) {
			throw new ListIndexOutOfBoundsException();
		}
		
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	
}

package queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale.LanguageRange;

/**
 * ArrayList-based min-heap data structure
 * @author Tony Song
 *
 * @param <E>
 */
public class Heap<E extends Comparable<E>> {
	private ArrayList<E> elements;
	
	/**
	 * Constructs an empty heap.
	 */
	public Heap() {
		elements = new ArrayList<E>();
	}
	
	/**
	 * Constructs a heap containing the elements of the specified 
	 * list.
	 * @param initial the list whose elements are to be placed into this heap
	 */
	public Heap(List<E> initial) {
		ArrayList<E> tempArr = new ArrayList<E>(initial);

		for (int i = tempArr.size() / 2 - 1; i >= 0; i--) {
			heapify(tempArr, i);
		}
		elements = tempArr;
	}
	
	/**
	 * Finds the index of the parent node of the given child node.
	 * It returns 0 if 0 is given.
	 * @param child the index of a child node
	 * @return the parent index of the given child index
	 */
	private int findParent(int child) {
		return (child - 1) / 2;
	}
	
	/**
	 * Finds the index of the left child node of the given parent node.
	 * It does not check if the left child exists.
	 * @param parent the index of a parent node
	 * @return the (expected) left child index of the given parent index
	 */
	private int findLeftChild(int parent) {
		return parent * 2 + 1;
	}
	
	/**
	 * Finds the index of the right child node of the given parent node.
	 * It does not check if the right child exists.
	 * @param parent the index of a parent node.
	 * @return the (expected) right child index of the given parent index.
	 */
	private int findRightChild(int parent) {
		return parent * 2 + 2;
	}
	
	/**
	 * Returns the number of elements in this heap.
	 * @return the number of elements in this heap.
	 */
	public int size() {
		return elements.size();
	}
	
	/**
	 * Returns true if this heap contains no elements.
	 * @return true if this heap contains no elements.
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	/**
	 * Make a heap tree whose root is at index. The root may violate the heap property,
	 * but both of its subtrees are heaps. Assume the given ArrayList is not empty.
	 */
	private void heapify(ArrayList<E> arr, int index) {
		int left = findLeftChild(index);
		int right = findRightChild(index);
		E current = arr.get(index);
		int smallest;
		
		if (left < arr.size() && (arr.get(left).compareTo(current) < 0)) {
			smallest = left;
		} else {
			smallest = index;
		}
		
		if (right < arr.size() && (arr.get(right).compareTo(arr.get(smallest)) < 0)) {
			smallest = right;
		}
		
		if (smallest != index) {
			// exchange elements.get(index) with elements.get(smallest)
			arr.set(index, arr.get(smallest));
			arr.set(smallest, current);
			heapify(arr, smallest);
		}
	}
	
	/**
	 * Inserts the specified element into this heap.
	 * @param element the element to add
	 */
	public void add(E element) {
		if (element == null) throw new NullPointerException();
		
		int current = elements.size();
		int parent = findParent(current);
		E temp;
		
		elements.add(element);
		
		while (current != 0 && elements.get(parent).compareTo(element) > 0) {
			// exchange current with parent
			temp = elements.get(parent);
			elements.set(parent, element);
			elements.set(current, temp);
			
			current = parent;
			parent = findParent(current);
		}
	}
	
	/**
	 * Retrieves, but does not remove, the head of this heap, or returns null if this heap is empty.
	 * @return the head of this heap, or null if this heap is empty
	 */
	public E peek() {
		if (elements.isEmpty()) return null;
		
		return elements.get(0);
	}
	
	/**
	 * Retrieves and removes the head of this heap, or returns null if this heap is empty.
	 * @return the head of this heap, or null if this heap is empty
	 */
	public E remove() {
		if (elements.isEmpty()) return null;

		E removed = elements.get(0);
		
		elements.set(0, elements.get(elements.size() - 1));
		elements.remove(elements.size() - 1);
		if (elements.size() != 0) heapify(elements, 0);
		
		return removed;
	}
}

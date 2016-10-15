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
	
	public Heap() {
		elements = new ArrayList<E>();
	}
	
	public Heap(List<E> initial) {
		ArrayList<E> tempArr = new ArrayList<E>(initial);

		for (int i = tempArr.size() / 2 - 1; i >= 0; i--) {
			heapify(tempArr, i);
		}
		elements = tempArr;
	}

	private int findParent(int child) {
		return (child - 1) / 2;
	}
	
	private int findLeftChild(int parent) {
		return parent * 2 + 1;
	}
	
	private int findRightChild(int parent) {
		return parent * 2 + 2;
	}
	
	public int size() {
		return elements.size();
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	// Assume everything below index assumed to be heaps and arr is not empty
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
	
	public void add(E element) {
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
	
	public E peek() {
		if (elements.isEmpty()) return null;
		
		return elements.get(0);
	}
	
	public E remove() {
		if (elements.isEmpty()) return null;

		E removed = elements.get(0);
		
		elements.set(0, elements.get(elements.size() - 1));
		elements.remove(elements.size() - 1);
		if (elements.size() != 0) heapify(elements, 0);
		
		return removed;
	}
}

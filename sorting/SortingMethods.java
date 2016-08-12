package sorting;

import java.util.Arrays;

/**
 * Collection of static sorting methods for arrays
 * @author Tony Song
 *
 */

public class SortingMethods {

	/**
	 * Find the largest item in an array within the size. 
	 * If there is more than one largest item, it returns the smallest index.
	 * @param theArray
	 * @param size
	 * @return the index of the largest item in an array.
	 */
	private static <T extends Comparable<? super T>> int indexOfLargest(T[] theArray, int size) {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		int largestID = 0;
		for (int i = 0; i < size; i++) {
			if (theArray[largestID].compareTo(theArray[i]) < 0) {
				largestID = i;
			}
		}
		return largestID;
	}
	
	/**
	 * Sort the items in an array into ascending order using selection sort.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] theArray) {
		for (int i = theArray.length - 1; i > 0; i--) {
			int largestID = indexOfLargest(theArray, i + 1);
			
			// swap elements at largestID and i
			T current = theArray[i];
			theArray[i] = theArray[largestID];
			theArray[largestID] = current;
		}
	}
	
	/**
	 * Sort the items in an array into ascending order using bubble sort.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] theArray) {
		boolean isSorted = true;
		do {
			isSorted = true;
			for (int i = 0; i < theArray.length - 1; i++) {
				if (theArray[i].compareTo(theArray[i + 1]) > 0) {
					T current = theArray[i];
					theArray[i] = theArray[i + 1];
					theArray[i + 1] = current;
					// not sorted because a swap happened
					isSorted = false;
				}				
			}
		} while (!isSorted);
	}
	
	/**
	 * Sort the items in an array into ascending order using insertion sort.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] theArray) {
		// one element is always sorted
		for (int unsortedID = 1; unsortedID < theArray.length; unsortedID++) {
			int leftID = unsortedID - 1;
			T current = theArray[unsortedID];
			while (leftID >= 0 && (theArray[leftID].compareTo(current) > 0)) {
				// swap left and current
				T left = theArray[leftID];
				theArray[leftID + 1] = left;
				theArray[leftID] = current;
				leftID--;
			}
		}
	}
	
	/**
	 * Merge two sorted portions of an array so that the portion from first to last
	 * is sorted. 
	 * @param theArray
	 * @param first
	 * @param mid
	 * @param last
	 * @param tempArray
	 */
	private static <T extends Comparable<? super T>> void merge(T[] theArray, int first, int mid, int last, T[] tempArray) {
		for (int i = first; i <= last; i++) {
			tempArray[i] = theArray[i];
		}
		
		// pointer id of the left portion of the array
		int left = first;
		// pointer id of the right portion of the array
		int right = mid + 1;
		// where to put the current element 
		int currentID = first;
		
		while (left <= mid && right <= last) {
			if (tempArray[left].compareTo(tempArray[right]) > 0) {
				theArray[currentID] = tempArray[right];
				right++;
				currentID++;
			} else {
				// stable because the left one always goes first in case of duplicates
				theArray[currentID] = tempArray[left];
				left++;
				currentID++;
			}
		}
		
		// process the leftover items
		int leftOver = left > mid ? right : left;
		while (currentID <= last) {
			theArray[currentID] = tempArray[leftOver];
			leftOver++;
			currentID++;
		}
	}
	
	/**
	 * Recursive helper for merge sort.
	 * @param theArray
	 * @param first
	 * @param last
	 * @param tempArray
	 */
	private static <T extends Comparable<? super T>> void mergeSortHelper(T[] theArray, int first, int last, T[] tempArray) {
		// the base case is when there is only one item
		if (first < last) {
			int mid = (first + last) / 2;
			mergeSortHelper(theArray, first, mid, tempArray);
			mergeSortHelper(theArray, mid + 1, last, tempArray);
			merge(theArray, first, mid, last, tempArray);
		}
	}
	
	/**
	 * Sort the items in an array into ascending order using merge sort.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void mergeSort(T[] theArray) {
		mergeSortHelper(theArray, 0, theArray.length - 1, (T[]) new Comparable<?>[theArray.length]);
	}
	
	/**
	 * Return the index of the pivot element after partitioning the array portion
	 * @param theArray
	 * @param first
	 * @param last
	 * @return the index of the pivot
	 */
	private static <T extends Comparable<? super T>> int partition(T[] theArray, int first, int last) {
		/*
         *                 S1                 S2            unknown part
         * +---------------------------------------------------------------+
         * | pivot |     < pivot     |     >= pivot     |         ?        |
         * +---------------------------------------------------------------+
         *      ^                   ^                    ^                ^
         *      |                   |                    |                |
         *    first               lastS1            firstUnknown         last
         *
         */
		T pivot = theArray[first];
		// S1 is empty
		int lastS1 = first;
		// S2 is empty
		int firstUnknown = first + 1;
		
		while (firstUnknown <= last) {
			if (theArray[firstUnknown].compareTo(pivot) < 0) {
				// move theArray[firstUnknown] to S1
				T unknown = theArray[firstUnknown];
				theArray[firstUnknown] = theArray[lastS1 + 1];
				theArray[lastS1 + 1] = unknown;
				lastS1++;
				firstUnknown++;
			} else {
				// move theArray[firstUnknown] to S2
				firstUnknown++;
			}
		}
		
		// swap theArray[first] and theArray[lastS1]
		theArray[first] = theArray[lastS1];
		theArray[lastS1] = pivot;
		
		return lastS1;
	}
	
	/**
	 * Sort the array portion from first to last.
	 * @param theArray
	 * @param first
	 * @param last
	 */
	private static <T extends Comparable<? super T>> void quickSortHelper(T[] theArray, int first, int last) {
		// the base case is when there is only one item
		if (first < last) {
			int pivotID = partition(theArray, first, last);
			
			// the item at pivotID is already sorted
			quickSortHelper(theArray, first, pivotID - 1);
			quickSortHelper(theArray, pivotID + 1, last);
		}
	}
	
	/**
	 * Sort the items in an array into ascending order using quick sort.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] theArray) {
		quickSortHelper(theArray, 0, theArray.length - 1);
	}
}

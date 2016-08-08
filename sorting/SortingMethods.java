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
}

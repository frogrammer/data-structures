package sorting;

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
	 * Sort the items in an array into ascending order.
	 * @param theArray
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] theArray) {
		for (int i = theArray.length - 1; i > 0; i--) {
			int largestID = indexOfLargest(theArray, i + 1);
			
			// swap elements at largestID and i
			T currentID = theArray[i];
			theArray[i] = theArray[largestID];
			theArray[largestID] = currentID;
		}
	}
}

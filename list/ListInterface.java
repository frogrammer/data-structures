package list;

import java.util.Iterator;

/**
 * Interface for the ADT list.
 * @author Tony Song
 *
 * @param <E>
 */

public interface ListInterface<E> {
	/**
	 * Return true if this list contains no elements.
	 * @return a boolean
	 */
	boolean isEmpty();
	
	/**
	 * Return the number of elements in this list
	 * @return an integer
	 */
	int size();
	
	/**
	 * Insert the specified item at the specified index in this list. 
	 * Throw ListIndexOutOfBoundsException if the index is out of bounds.
	 * @param index
	 * @param item
	 * @throws ListIndexOutOfBoundsException
	 */
	void add(int index, E item) 
			throws ListIndexOutOfBoundsException;
	
	/**
	 * Remove the node at the specified index in this list. 
	 * Throw ListIndexOutOfBoundsException if the index is out of bounds 
	 * or the list is empty.
	 * @param index
	 * @throws ListIndexOutOfBoundsException
	 */
	void remove(int index) 
			throws ListIndexOutOfBoundsException;
	
	/**
	 * Return the item at the specified index in this list. 
	 * Throw ListIndexOurOfBoundsException if the index is out of bounds 
	 * or the list is empty.
	 * @param index
	 * @return the item at the given index
	 * @throws ListIndexOutOfBoundsException
	 */
	E get(int index) 
			throws ListIndexOutOfBoundsException;
	
	/**
	 * Remove all of the elements from this list
	 */
	void clear();
	
	/**
	 * Return an iterator over the elements in this list in proper sequence.
	 * @return an iterator
	 */
	Iterator<E> iterator();
}

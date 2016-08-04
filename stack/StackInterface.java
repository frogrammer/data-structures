package stack;

import java.util.EmptyStackException;

/**
 * Interface for the ADT stack.
 * @author Tony Song
 *
 * @param <E>
 */

public interface StackInterface<E> {
	/**
	 * Return true if this stack contains no elements.
	 * @return a boolean
	 */
	boolean isEmpty();
	
	/**
	 * Remove all the items from the stack.
	 */
	void clear();
	
	/**
	 * Add an item to the top of a stack.
	 * @param newItem
	 */
	void push(E newItem);
	
	/**
	 * Remove the top of a stack and return it. 
	 * Throw EmptyStackException if the stack is empty.
	 * @return the top item
	 * @throws EmptyStackException
	 */
	E pop() throws EmptyStackException;
	
	/**
	 * Retrieve the top of a stack. 
	 * Throw EmptyStackException if the stack is empty.
	 * @return
	 * @throws EmptyStackException
	 */
	E peek() throws EmptyStackException;
}

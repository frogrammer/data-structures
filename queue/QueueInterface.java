package queue;

import java.util.NoSuchElementException;

/**
 * Interface for the ADT queue.
 * @author Tony Song
 *
 * @param <E>
 */

public interface QueueInterface<E> {
	/**
	 * Return true if the queue contains no element.
	 * @return a boolean
	 */
	boolean isEmpty();
	
	/**
	 * Add an item at the back of a queue.
	 * @param newItem
	 */
	void enqueue(E newItem);
	
	/**
	 * Retrieve and remove the front of a queue. Throw NoSuchElementException
	 * if the queue is empty.
	 * @return the element at the front
	 * @throws NoSuchElementException
	 */
	E dequeue() throws NoSuchElementException;
	
	/**
	 * Remove all items of a queue.
	 */
	void dequeueAll();
	
	/**
	 * Retrieve the item at the front of a queue. Throw NoSuchElementException
	 * if the queue is empty.
	 * @return the element at the front
	 * @throws NoSuchElementException
	 */
	E peek() throws NoSuchElementException;
}

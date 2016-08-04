package queue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * ArrayList-based implementation of ADT queue.
 * @author Tony Song
 *
 * @param <E>
 */

public class MyQueue<E> implements QueueInterface<E> {
	private ArrayList<E> aList = new ArrayList<>();
	
	@Override
	public boolean isEmpty() {
		return aList.isEmpty();
	}

	@Override
	public void enqueue(E newItem) {
		aList.add(newItem);
	}

	@Override
	public E dequeue() {
		if (aList.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		return aList.remove(0);
	}

	@Override
	public void dequeueAll() {
		aList.clear();
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (aList.isEmpty()) {
			throw new NoSuchElementException("The queue is empty.");
		}
		return aList.get(0);
	}

}

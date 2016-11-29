package queue;

import java.util.NoSuchElementException;

/**
 * LinkedList-based implementation of ADT queue
 * @author Tony Song
 *
 * @param <E>
 */

public class MyQueue<E> implements QueueInterface<E> {
	private static class QueueNode<E> {
		private E data;
		private QueueNode<E> next;
		
		public QueueNode(E data) {
			this.data = data;
		}
	}
	
	private QueueNode<E> first;
	private QueueNode<E> last;
	
	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void enqueue(E newItem) {
		QueueNode<E> t = new QueueNode<>(newItem);

		if (first == null) {
			first = t;
			last = first;
		} else {
			last.next = t;
			last = last.next;
		}
	}

	@Override
	public E dequeue() {
		if (first == null) {
			throw new NoSuchElementException("The queue is empty.");
		}
		E toReturn = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return toReturn;
	}

	@Override
	public void dequeueAll() {
		first = null;
		last = null;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (first == null) {
			throw new NoSuchElementException("The queue is empty.");
		}
		return first.data;
	}
}
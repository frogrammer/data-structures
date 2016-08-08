package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * ArrayList-based implementation of ADT stack
 * @author Tony Song
 *
 * @param <E>
 */

public class MyStack<E> implements StackInterface<E> {
	private ArrayList<E> arrList = new ArrayList<>();
	
	@Override
	public boolean isEmpty() {
		return arrList.isEmpty();
	}

	@Override
	public void clear() {
		arrList.clear();
	}

	@Override
	public void push(E newItem) {
		arrList.add(newItem);
	}

	@Override
	public E pop() throws EmptyStackException {
		if (arrList.isEmpty()) {
			throw new EmptyStackException();
		}
		return arrList.remove(arrList.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (arrList.isEmpty()) {
			throw new EmptyStackException();
		}
		return arrList.get(arrList.size() - 1);
	}

}

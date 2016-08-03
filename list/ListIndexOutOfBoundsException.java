package list;

/**
 * Exception class to check the index of the ADT list.
 * @author Tony Song
 *
 */

public class ListIndexOutOfBoundsException extends IndexOutOfBoundsException {
	public ListIndexOutOfBoundsException() {
		super();
	}
	public ListIndexOutOfBoundsException(String s) {
		super(s);
	}
}

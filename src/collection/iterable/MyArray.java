package collection.iterable;

import java.util.Iterator;

/**
 * My Array
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class MyArray implements Iterable<Integer> {

	private int[] numbers;

	public MyArray(int[] numbers) {
		this.numbers = numbers;
	}


	@Override
	public Iterator<Integer> iterator() {
		return new MyArrayIterator(numbers);
	}
}
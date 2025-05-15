package collection.iterable;

import java.util.Iterator;

/**
 * My Array Iterator
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class MyArrayIterator implements Iterator<Integer> {

	private int currentIndex = -1;
	private int[] targetArr;

	public MyArrayIterator(int[] targetArr) {
		this.targetArr = targetArr;
	}

	@Override
	public boolean hasNext() {
		return currentIndex < targetArr.length - 1;
	}

	@Override
	public Integer next() {
		return targetArr[++currentIndex];
	}
}
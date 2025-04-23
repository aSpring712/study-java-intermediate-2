package generic.quiz.ex1;

/**
 * Container
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class Container<T> {

	private T item;

	public void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}

	public boolean isEmpty() {
		return item == null;
	}
}
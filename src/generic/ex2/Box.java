package generic.ex2;

/**
 * Box
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class Box<T> {

	private T  value;

	public void set(T value) {
		this.value = value;
	}

	public T get() {
		return value;
	}
}
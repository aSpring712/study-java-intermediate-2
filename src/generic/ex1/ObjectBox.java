package generic.ex1;

/**
 * Object Box
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class ObjectBox {

	private Object value;

	public void set(Object object) {
		this.value = object;
	}

	public Object get() {
		return this.value;
	}
}
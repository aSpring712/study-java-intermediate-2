package generic.ex1;

/**
 * Raw Type Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class RawTypeMain {

	public static void main(String[] args) {
		GenericBox integerBox = new GenericBox();
//		GenericBox<Object> integerBox = new GenericBox<>(); // 권장
		integerBox.set(10);
		Integer result = (Integer) integerBox.get();
		System.out.println("result = " + result);
	}
}
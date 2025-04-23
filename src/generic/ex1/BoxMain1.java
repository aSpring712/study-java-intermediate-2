package generic.ex1;

/**
 * Box Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class BoxMain1 {

	public static void main(String[] args) {
		IntegerBox integerBox = new IntegerBox();
		integerBox.set(10); // 오토 박싱
		Integer integer = integerBox.get();
		System.out.println("integer = " + integer);

		StringBox stringBox = new StringBox();
		stringBox.set("hello");
		String str = stringBox.get();
		System.out.println("str = " + str);
	}
}
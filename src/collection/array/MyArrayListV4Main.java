package collection.array;

/**
 * My Array List V4 Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class MyArrayListV4Main {

	public static void main(String[] args) {
		MyArrayListV4<String> stringList = new MyArrayListV4<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		String string = stringList.get(0);
		System.out.println("string = " + string);

		MyArrayListV4<Integer> intList = new MyArrayListV4<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Integer integer = intList.get(0);
		System.out.println("integer = " + integer);
	}
}
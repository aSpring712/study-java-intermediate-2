package collection.link;

/**
 * My Linked List V3 Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class MyLinkedListV3Main {

	public static void main(String[] args) {
		MyLinkedListV3<String> stringList = new MyLinkedListV3<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		String string = stringList.get(0);
		System.out.println("string = " + string);

		MyLinkedListV3<Integer> intList = new MyLinkedListV3<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		Integer integer = intList.get(0);
		System.out.println("integer = " + integer);
	}
}
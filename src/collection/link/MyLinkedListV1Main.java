package collection.link;

/**
 * My Linked List V1 Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class MyLinkedListV1Main {

	public static void main(String[] args) {
		MyLinkedListV1 list = new MyLinkedListV1();
		System.out.println("==데이터 추가==");
		System.out.println(list);
		list.add("a");
		System.out.println(list);
		list.add("b");
		System.out.println(list);
		list.add("c");
		System.out.println(list);

		System.out.println("==기능 사용==");
		System.out.println("lize.size(): " + list.size());
		System.out.println("lize.get(1): " + list.get(1));
		System.out.println("lize.indexOf('c'): " + list.indexOf("c"));
		System.out.println("lize.set(2, 'z'): " + list.set(2, "z"));
		System.out.println(list);

		System.out.println("==범위 초과==");
		list.add("d");
		System.out.println(list);
		list.add("e");
		System.out.println(list);
		list.add("f");
		System.out.println(list);
	}
}
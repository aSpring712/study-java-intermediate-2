package collection.set;

/**
 * My Hash Set V3 Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class MyHashSetV3Main {

	public static void main(String[] args) {
		MySet<String> set = new MyHashSetV3<>(10);
		set.add("A");
		set.add("B");
		set.add("C");
		System.out.println(set);

		// 검색
		String searchValue = "A";
		boolean result = set.contains(searchValue);
		System.out.println("set.contains(" + searchValue + ") = " + result);
	}
}
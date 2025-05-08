package collection.set;

/**
 * My Hash Set V2 Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class MyHashSetV2Main1 {

	public static void main(String[] args) {
		MyHashSetV2 set = new MyHashSetV2(10);
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("AB");
		set.add("SET");
		System.out.println(set);

		System.out.println("A.hashCode = " + "A".hashCode()); // 65
		System.out.println("B.hashCode = " + "B".hashCode()); // 66
		System.out.println("AB.hashCode = " + "AB".hashCode()); // 2081
		System.out.println("SET.hashCode = " + "SET".hashCode()); // 81986

		// 검색
		String searchValue = "SET";
		boolean result = set.contains(searchValue);
		System.out.println("set.contains(" + searchValue + ") = " + result); // true
	}
}
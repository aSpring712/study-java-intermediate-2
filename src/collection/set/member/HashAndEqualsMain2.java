package collection.set.member;

import collection.set.MyHashSetV2;

/**
 * Hash And Equals Main 2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class HashAndEqualsMain2 {

	public static void main(String[] args) {
		// 중복 등록
		MyHashSetV2 set = new MyHashSetV2(10);
		MemberOnlyHash m1 = new MemberOnlyHash("A");
		MemberOnlyHash m2 = new MemberOnlyHash("A");
		System.out.println("m1.hashCode() = " + m1.hashCode()); // 96
		System.out.println("m2.hashCode() = " + m2.hashCode()); // 96
		System.out.println("m1.equals(m2) = " + m1.equals(m2)); // false

		set.add(m1);
		set.add(m2);
		System.out.println(set);

		// 검색 실패
		MemberOnlyHash searchValue = new MemberOnlyHash("A");
		System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); // 96
		boolean contains = set.contains(searchValue);
		System.out.println("contains = " + contains); // false
	}
}
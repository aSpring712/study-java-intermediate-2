package collection.set.member;

import collection.set.MyHashSetV2;

/**
 * Hash And Equals Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class HashAndEqualsMain1 {

	public static void main(String[] args) {
		// 중복 등록
		MyHashSetV2 set = new MyHashSetV2(10);
		MemberNoHashNoEq m1 = new MemberNoHashNoEq("A");
		MemberNoHashNoEq m2 = new MemberNoHashNoEq("A");
		System.out.println("m1.hashCode() = " + m1.hashCode()); // 1867083167
		System.out.println("m2.hashCode() = " + m2.hashCode()); // 885284298
		System.out.println("m1.equals(m2) = " + m1.equals(m2)); // false

		set.add(m1);
		set.add(m2);
		System.out.println(set);

		// 검색 실패
		MemberNoHashNoEq searchValue = new MemberNoHashNoEq("A");
		System.out.println("searchValue.hashCode() = " + searchValue.hashCode()); // 1848402763
		boolean contains = set.contains(searchValue);
		System.out.println("contains = " + contains); // false
	}
}
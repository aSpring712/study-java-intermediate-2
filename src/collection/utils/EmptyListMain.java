package collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Empty List Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class EmptyListMain {

	public static void main(String[] args) {
		// 빈 가변 리스트 생성
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new LinkedList<>();

		// 빈 불변 리스트 생성
		List<Integer> list3 = Collections.emptyList(); // 자바 5
		List<Integer> list4 = List.of(); // 자바 9

		System.out.println("list3 = " + list3.getClass());
		System.out.println("list4 = " + list4.getClass());
	}
}
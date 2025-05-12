package collection.set.quiz;

import java.util.HashSet;
import java.util.Set;

/**
 * Unique Names Test 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-12
 * @version 1.0
 */
public class UniqueNamesTest1 {

	public static void main(String[] args) {
		Integer[] inputArr = {30, 20, 20, 10, 10};
		Set<Integer> set = new HashSet<>();
		for (Integer s : inputArr) {
			set.add(s);
		}

		for (Integer s : set) {
			System.out.println(s);
		}
	}
}
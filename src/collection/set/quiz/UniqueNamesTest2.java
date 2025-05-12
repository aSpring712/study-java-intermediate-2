package collection.set.quiz;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Unique Names Test 2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-12
 * @version 1.0
 */
public class UniqueNamesTest2 {

	public static void main(String[] args) {
		Integer[] inputArr = {30, 20, 20, 10, 10};
		Set<Integer> set = new LinkedHashSet<>(List.of(inputArr));

		for (Integer s : set) {
			System.out.println(s);
		}
	}
}
package collection.set.quiz;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Unique Names Test 3
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-12
 * @version 1.0
 */
public class UniqueNamesTest3 {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>(List.of(30, 20, 20, 10, 10));

		for (Integer s : set) {
			System.out.println(s);
		}
	}
}
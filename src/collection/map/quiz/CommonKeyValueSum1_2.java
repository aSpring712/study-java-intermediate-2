package collection.map.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Common Key Value Sum 1_2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class CommonKeyValueSum1_2 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
		Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);

		Map<String, Integer> result = new HashMap<>();

		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				result.put(key, map1.get(key) + map2.get(key));
			}
		}

		System.out.println(result);
	}
}
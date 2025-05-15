package collection.map.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Common Key Value Sum 1_1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class CommonKeyValueSum1_1 {

	public static void main(String[] args) {
		Map<String, Integer> map1 = new HashMap<>();
		map1.put("A", 1);
		map1.put("B", 2);
		map1.put("C", 3);

		Map<String, Integer> map2 = new HashMap<>();
		map2.put("B", 4);
		map2.put("C", 5);
		map2.put("D", 6);

		Map<String, Integer> result = new HashMap<>();

		// 코드 작성
		for (String key : map1.keySet()) {
			if (map2.containsKey(key)) {
				result.put(key, map1.get(key) + map2.get(key));
			}
		}

		System.out.println(result);
	}
}
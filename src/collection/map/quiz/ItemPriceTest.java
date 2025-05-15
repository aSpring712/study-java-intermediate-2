package collection.map.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Item Price Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class ItemPriceTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("사과", 500);
		map.put("바나나", 500);
		map.put("망고", 1000);
		map.put("딸기", 1000);

		List<String> list = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(1000)) {
				list.add(entry.getKey());
			}
		}

		System.out.println(list);
	}
}
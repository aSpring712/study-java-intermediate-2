package collection.map.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Frequency Test 1_1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class WordFrequencyTest1_1 {

	public static void main(String[] args) {
		String text = "orange banana apple apple banana apple";

		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split(" ");

		for (String word : words) {
			Integer count = map.get(word);
			if (count == null) {
				count = 0;
			}
			count++;

			map.put(word, count);
		}

		System.out.println(map);
	}
}
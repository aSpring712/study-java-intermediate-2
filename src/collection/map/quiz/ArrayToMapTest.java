package collection.map.quiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Array To Map Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-14
 * @version 1.0
 */
public class ArrayToMapTest {

	public static void main(String[] args) {
		String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

		// 주어진 배열로부터 Map 생성
		Map<String, Integer> productMap = new HashMap<>();
		for (String[] product : productArr) {
			productMap.put(product[0], Integer.valueOf(product[1]));
		}

		// Map의 모든 데이터 출력
		for (String key : productMap.keySet()) {
			System.out.println("제품: " + key + ", 가격: " + productMap.get(key));
		}
	}
}
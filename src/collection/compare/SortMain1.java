package collection.compare;

import java.util.Arrays;

/**
 * Sort Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class SortMain1 {

	public static void main(String[] args) {
		Integer[] array = {3, 2, 1};
		System.out.println(Arrays.toString(array));

		System.out.println("기본 정렬 후");
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
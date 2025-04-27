package collection.array;

import java.util.Arrays;

/**
 * Array Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class ArrayMain1 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		// index 입력: 0(1)
		System.out.println("==index 입력: 0(1)==");
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		System.out.println(Arrays.toString(arr));

		// index 변경: 0(1)
		System.out.println("==index 변경: 0(1)==");
		arr[2] = 10;
		System.out.println(Arrays.toString(arr));

		// index 조회: 0(1)
		System.out.println("==index 조회: 0(1)==");
		System.out.println("arr[2] = " + arr[2]);

		// 검색: 0(n)
		System.out.println("배열 검색: 0(n)");
		System.out.println(Arrays.toString(arr));
		int value = 10;
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]: " + arr[i]);
			if (arr[i] == value) {
				System.out.println(value + " 찾음");
				break;
			}
		}
	}
}
package collection.array;

/**
 * My Array List V3 Bad Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class MyArrayListV3BadMain {

	public static void main(String[] args) {
		MyArrayListV3 numberList = new MyArrayListV3();

		// 숫자만 입력 하기를 기대
		numberList.add(1);
		numberList.add(2);
		numberList.add("문자"); // 문자를 입력
		System.out.println(numberList);

		// Object를 반환하므로 다운 캐스팅 필요
		Integer num1 = (Integer) numberList.get(0);
		Integer num2 = (Integer) numberList.get(1);

		// ClassCastException 발생, 문자를 Integer로 캐스팅
		Integer num3 = (Integer) numberList.get(2);
	}
}
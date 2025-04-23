package generic.quiz.ex1;

/**
 * ContainerTest
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class ContainerTest {

	public static void main(String[] args) {

		Container<String> stringContainer = new Container<>();
		System.out.println("빈값 확인1: " + stringContainer.isEmpty()); // true

		stringContainer.setItem("data1");
		System.out.println("저장 데이터: " + stringContainer.getItem()); // data1
		System.out.println("빈값 확인2: " + stringContainer.isEmpty()); // false

		Container<Integer> integerContainer = new Container<>();
		integerContainer.setItem(10);
		System.out.println("저장 데이터: " + integerContainer.getItem()); // 10
	}
}
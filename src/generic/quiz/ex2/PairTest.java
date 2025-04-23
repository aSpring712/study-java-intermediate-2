package generic.quiz.ex2;

/**
 * Pair Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class PairTest {

	public static void main(String[] args) {

		Pair<Integer, String> pair1 = new Pair<>();
		pair1.setFirst(1);
		pair1.setSecond("data");
		System.out.println(pair1.getFirst());
		System.out.println(pair1.getSecond());
		System.out.println("pair1 = " + pair1);

		Pair<String, String> pair2 = new Pair<>();
		pair2.setFirst("key");
		pair2.setSecond("value");
		System.out.println(pair2.getFirst());
		System.out.println(pair2.getSecond());
		System.out.println("pair2 = " + pair2);
	}
}
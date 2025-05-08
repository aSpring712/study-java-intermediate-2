package collection.list.quiz.ex1;

/**
 * Array Ex 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-04
 * @version 1.0
 */
public class ArrayEx1 {

	public static void main(String[] args) {
		int[] students = {90, 80, 70, 60, 50};

		int total = 0;
		for (int i = 0; i <students.length; i++) {
			total += students[i];
		}

		double average = (double) total / students.length;
		System.out.println("점수 총합: " + total);
		System.out.println("점수 평균: " + average);
	}
}
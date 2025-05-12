package collection.set.quiz;

import java.util.HashSet;
import java.util.Set;

/**
 * Rectangle Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-12
 * @version 1.0
 */
public class RectangleTest {

	public static void main(String[] args) {
		Set<Rectangle> rectangleSet = new HashSet<>();
		rectangleSet.add(new Rectangle(10, 20));
		rectangleSet.add(new Rectangle(20, 20));
		rectangleSet.add(new Rectangle(20, 20)); // 중복

		for (Rectangle rectangle : rectangleSet) {
			System.out.println("rectangle = " + rectangle);
		}
	}
}
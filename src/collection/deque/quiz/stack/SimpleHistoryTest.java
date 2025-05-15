package collection.deque.quiz.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Simple History Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class SimpleHistoryTest {

	public static void main(String[] args) {
		Deque<String> stack = new ArrayDeque<>();

		stack.push("youtube.com");
		stack.push("google.com");
		stack.push("facebook.com");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
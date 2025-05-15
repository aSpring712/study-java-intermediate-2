package collection.deque.quiz.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Printer Queue Test
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class PrinterQueueTest {

	public static void main(String[] args) {
		Queue<String> printQueue = new ArrayDeque<>();

		printQueue.offer("doc1");
		printQueue.offer("doc2");
		printQueue.offer("doc3");

		System.out.println("출력: " + printQueue.poll());
		System.out.println("출력: " + printQueue.poll());
		System.out.println("출력: " + printQueue.poll());
	}
}
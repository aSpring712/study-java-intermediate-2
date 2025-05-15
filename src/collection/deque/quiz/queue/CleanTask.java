package collection.deque.quiz.queue;

/**
 * Clean Task
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class CleanTask implements Task {

	@Override
	public void execute() {
		System.out.println("사용하지 않는 자원 정리...");
	}
}
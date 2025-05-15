package collection.deque.quiz.queue;

/**
 * Backup Task
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class BackupTask implements Task {

	@Override
	public void execute() {
		System.out.println("자료 백업...");
	}
}
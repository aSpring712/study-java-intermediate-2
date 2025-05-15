package collection.deque.quiz.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Task Scheduler
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class TaskScheduler {
	private Queue<Task> tasks = new ArrayDeque<>();

	public void addTask(Task task) {
		tasks.offer(task);
	}

	public void processNextTask() {
		Task task = tasks.poll();
		if (task != null) {
			task.execute();
		}
	}

	public int getRemainingTasks() {
		return tasks.size();
	}
}
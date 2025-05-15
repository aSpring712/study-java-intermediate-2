package collection.deque.quiz.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Browser History
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class BrowserHistory {

	private Deque<String> history = new ArrayDeque<>();
	private String currentPage = null;

	public void visitPage(String url) {
		if (currentPage != null) {
			history.push(currentPage);
		}
		currentPage = url;
		System.out.println("방문: " + url);
	}

	public String goBack() {
		if (!history.isEmpty()) {
			currentPage = history.pop();
			System.out.println("뒤로 가기: " + currentPage);
			return currentPage;
		}
		return null;
	}
}
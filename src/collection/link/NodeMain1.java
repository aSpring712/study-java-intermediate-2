package collection.link;

/**
 * Node Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class NodeMain1 {

	public static void main(String[] args) {
		// 노드 생성하고 연결하기: A -> B -> C
		Node first = new Node("A");
		first.next = new Node("B");
		first.next.next = new Node("C");

		System.out.println("모든 노트 탐색하기");
		Node x = first;
		while (x != null) {
			System.out.println(x.item);
			x = x.next;
		}
	}
}
package collection.link;

/**
 * Node Main 2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class NodeMain2 {

	public static void main(String[] args) {
		// 노드 생성하고 연결하기: A -> B -> C
		Node first = new Node("A");
		first.next = new Node("B");
		first.next.next = new Node("C");

		System.out.println("연결된 노드 출력하기");
		System.out.println(first);
	}
}
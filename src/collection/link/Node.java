package collection.link;

/**
 * Node
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-27
 * @version 1.0
 */
public class Node {

	Object item;
	Node next;

	public Node(Object item) {
		this.item = item;
	}

	/*@Override
	public String toString() {
		return "Node{" +
				"item=" + item +
				", next=" + next +
				'}';
	}*/

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node x = this;
		sb.append("[");
		while (x != null) {
			sb.append(x.item);
			if (x.next != null) {
				sb.append("->");
			}
			x = x.next;
		}
		sb.append("]");
		return sb.toString();
	}
}
package collection.map.quiz.member;

/**
 * Member
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class Member {

	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
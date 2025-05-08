package collection.set.member;

/**
 * Member No Hash No Eq
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class MemberNoHashNoEq {

	private String id;

	public MemberNoHashNoEq(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "MemberNoHashNoEq{" +
				"id='" + id + '\'' +
				'}';
	}
}
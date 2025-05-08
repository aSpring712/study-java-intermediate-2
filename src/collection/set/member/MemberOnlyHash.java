package collection.set.member;

import java.util.Objects;

/**
 * Member Only Hash
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class MemberOnlyHash {

	private String id;

	public MemberOnlyHash(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "MemberOnlyHash{" +
				"id='" + id + '\'' +
				'}';
	}
}
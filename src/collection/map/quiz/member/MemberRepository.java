package collection.map.quiz.member;

import java.util.HashMap;
import java.util.Map;

/**
 * Member Repository
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class MemberRepository {

	private Map<String, Member> memberMap = new HashMap<>();

	public void save(Member member) {
		memberMap.put(member.getId(), member);
	}

	public void remove(String id) {
		memberMap.remove(id);
	}

	public Member findById(String id) {
		return memberMap.get(id);
	}

	public Member findByName(String name) {
		for (Member member : memberMap.values()) {
			if (member.getName().equals(name)) {
				return member;
			}
		}
		return null;
	}
}
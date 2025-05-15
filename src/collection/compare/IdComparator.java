package collection.compare;

import java.util.Comparator;

/**
 * ID Comparator
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class IdComparator implements Comparator<MyUser> {

	@Override
	public int compare(MyUser o1, MyUser o2) {
		return o1.getId().compareTo(o2.getId());
	}
}
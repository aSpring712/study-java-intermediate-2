package generic.quiz.ex3.unit;

/**
 * Unit Util
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-24
 * @version 1.0
 */
public class UnitUtil {

	public static <T extends BioUnit> T maxHp(T t1, T t2) {
		return t1.getHp() > t2.getHp() ? t1 : t2;
	}
}
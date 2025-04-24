package generic.quiz.ex3;

import generic.quiz.ex3.unit.BioUnit;

/**
 * Unit Printer
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-24
 * @version 1.0
 */
public class UnitPrinter {

	public static <T extends BioUnit> void printV1(Shuttle<T> t1) {
		T unit = t1.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}

	public static void printV2(Shuttle<? extends BioUnit> t1) {
		BioUnit unit = t1.out();
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}
}
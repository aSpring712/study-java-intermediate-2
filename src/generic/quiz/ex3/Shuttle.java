package generic.quiz.ex3;

import generic.quiz.ex3.unit.BioUnit;

/**
 * Shuttle
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-24
 * @version 1.0
 */
public class Shuttle<T extends BioUnit> {

	private T unit;

	public void in(T t) {
		this.unit = t;
	}

	public T out() {
		return unit;
	}

	public void showInfo() {
		System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
	}
}
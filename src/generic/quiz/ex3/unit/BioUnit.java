package generic.quiz.ex3.unit;

/**
 * Bio Unit
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-24
 * @version 1.0
 */
public class BioUnit {

	private String name;
	private int hp;

	public BioUnit(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	@Override
	public String toString() {
		return "BioUnit{" +
				"name='" + name + '\'' +
				", hp=" + hp +
				'}';
	}
}
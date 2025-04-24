package generic.animal;

/**
 * Dog
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class Dog extends Animal {

	public Dog(String name, int size) {
		super(name, size);
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
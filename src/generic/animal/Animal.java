package generic.animal;

/**
 * Animal
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class Animal {

	private String name;
	private int size;

	public Animal(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void sound() {
		System.out.println("동물 울음 소리");
	}

	@Override
	public String toString() {
		return "Animal{" +
				"name='" + name + '\'' +
				", size=" + size +
				'}';
	}
}
package generic.ex3;

import generic.animal.Dog;

/**
 * Dog Hospital
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class DogHospital {

	private Dog animal;

	public void set(Dog animal) {
		this.animal = animal;
	}

	public void checkup() {
		System.out.println("동물 이름: " + animal.getName());
		System.out.println("동물 크기: " + animal.getSize());
		animal.sound();
	}

	public Dog bigger(Dog target) {
		return animal.getSize() > target.getSize() ? animal : target;
	}
}
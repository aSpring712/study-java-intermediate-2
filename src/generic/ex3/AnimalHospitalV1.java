package generic.ex3;

import generic.animal.Animal;

/**
 * Animal Hospital V1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class AnimalHospitalV1 {

	private Animal animal;

	public void set(Animal animal) {
		this.animal = animal;
	}

	public void checkup() {
		System.out.println("동물 이름: " + animal.getName());
		System.out.println("동물 크기: " + animal.getSize());
		animal.sound();
	}

	public Animal getBigger(Animal target) {
		return animal.getSize() > target.getSize() ? animal : target;
	}
}
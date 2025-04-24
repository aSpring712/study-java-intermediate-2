package generic.ex3;

import generic.animal.Animal;

/**
 * Animal Hospital V3
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class AnimalHospitalV3<T extends Animal> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public void checkup() {

		System.out.println("동물 이름: " + animal.getName());
		System.out.println("동물 크기: " + animal.getSize());
		animal.sound();
	}

	public T getBigger(T target) {
		// 컴파일 오류
		return animal.getSize() > target.getSize() ? animal : target;
	}
}
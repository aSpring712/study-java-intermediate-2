package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

/**
 * Method Main 2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class MethodMain2 {

	public static void main(String[] args) {

		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냐옹이", 100);

		AnimalMethod.checkup(dog);
		AnimalMethod.checkup(cat);

		Dog targetDog = new Dog("큰 멍멍이", 200);
		Dog bigger = AnimalMethod.getBigger(dog, targetDog);
		System.out.println("bigger = " + bigger);
	}
}
package generic.ex4;

import generic.animal.Cat;
import generic.animal.Dog;

/**
 * Method Main 3
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class MethodMain3 {

	public static void main(String[] args) {
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냐옹이", 50);

		ComplexBox<Dog> hospital = new ComplexBox<>();
		hospital.set(dog);

		Cat returnCat = hospital.printAndReturn(cat);
		System.out.println("returnCat = " + returnCat);
	}
}
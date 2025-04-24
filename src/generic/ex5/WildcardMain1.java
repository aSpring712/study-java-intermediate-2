package generic.ex5;

import generic.animal.Animal;
import generic.animal.Cat;
import generic.animal.Dog;

/**
 * Wildcard Main 1
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class WildcardMain1 {

	public static void main(String[] args) {

		Box<Object> objectBox = new Box<>();
		Box<Dog> dogBox = new Box<>();
		Box<Cat> catBox = new Box<>();
		dogBox.set(new Dog("멍멍이", 100));

		WildcardEx.printGenericV1(dogBox);
		WildcardEx.printWildcardV1(dogBox);

		WildcardEx.printGenericV2(dogBox);
		WildcardEx.printWildcardV2(dogBox);

		Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
		Animal animal = WildcardEx.printAndReturnWildcard(dogBox);
	}
}
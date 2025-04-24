package generic.ex4;

import generic.animal.Animal;

/**
 * Complex Box
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class ComplexBox<T extends Animal> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public <Z> Z printAndReturn(Z z) {
		System.out.println("animal.className: " + animal.getClass().getName());
		System.out.println("z.className: " + z.getClass().getName());
//		z.getName(); // 호출 불가 메서드는 <T> 타입이다. <T extends Animal> 타입이 아니다.
		return z;
	}
}
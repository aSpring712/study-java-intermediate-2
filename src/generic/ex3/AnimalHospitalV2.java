package generic.ex3;

/**
 * Animal Hospital V2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class AnimalHospitalV2<T> {

	private T animal;

	public void set(T animal) {
		this.animal = animal;
	}

	public void checkup() {
		// T의 타입을 메서드를 정의하는 시점에는 알 수 없다. Object의 기능만 사용 가능
		animal.toString();
		animal.equals(null);

		// 컴파일 오류
//		System.out.println("동물 이름: " + animal.getName());
//		animal.sound();
	}

	public T getBigger(T target) {
		// 컴파일 오류
//		return animal.getSize() > target.getSize() ? animal : target;
		return null;
	}
}
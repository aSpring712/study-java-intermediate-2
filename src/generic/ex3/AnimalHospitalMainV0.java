package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

/**
 * Animal Hospital Main V0
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class AnimalHospitalMainV0 {

	public static void main(String[] args) {

		DogHospital dogHospital = new DogHospital();
		CatHospital catHospital = new CatHospital();

		Dog dog = new Dog("멍멍이1", 100);
		Cat cat = new Cat("냐옹이1", 50);

		// 개 병원
		dogHospital.set(dog);
		dogHospital.checkup();

		// 고양이 병원
		catHospital.set(cat);
		catHospital.checkup();

		// 문제1: 개 병원에 고양이 전달
//		dogHospital.set(cat); // 다른 타입 입력: 컴파일 오류

		// 문제2: 개 타입 반환
		dogHospital.set(dog);
		Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
		System.out.println("biggerDog = " + biggerDog);
	}
}
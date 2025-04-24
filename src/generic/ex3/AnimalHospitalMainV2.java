package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

/**
 * Animal Hospital Main V2
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class AnimalHospitalMainV2 {

	public static void main(String[] args) {

		AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Integer> integerHospital = new AnimalHospitalV2<>();
		AnimalHospitalV2<Object> objectHospital = new AnimalHospitalV2<>();
	}
}
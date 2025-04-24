package generic.ex4;

/**
 * Generic Method
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-04-23
 * @version 1.0
 */
public class GenericMethod {

	public static Object objMethod(Object obj) {
		System.out.println("object print: " + obj);
		return obj;
	}

	public static <T> T genericMethod(T t) {
		System.out.println("generic print: " + t);
		return t;
	}

	public static <T extends Number> T numberMethod(T t) {
		System.out.println("bound print: " + t);
		return t;
	}
}
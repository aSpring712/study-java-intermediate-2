package collection.map.quiz.cart;

/**
 * Cart Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class CartMain {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.add(new Product("사과", 1000), 1);
		cart.add(new Product("바나나", 500), 1);
		cart.printAll();

		cart.add(new Product("사과", 1000), 2);
		cart.printAll();

		cart.minus(new Product("사과", 1000), 3);
		cart.printAll();
	}
}
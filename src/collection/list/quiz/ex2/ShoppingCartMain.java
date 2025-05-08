package collection.list.quiz.ex2;

/**
 * Shopping Cart Main
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-08
 * @version 1.0
 */
public class ShoppingCartMain {

	public static void main(String[] args) {

		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("마늘", 2000, 2);
		Item item2 = new Item("상추", 3000, 4);

		cart.addItem(item1);
		cart.addItem(item2);

		cart.displayItems();
	}
}
package collection.compare.quiz;

/**
 * Suit
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public enum Suit {
	SPADE("♠"), // 스페이드(♠)
	HEART("♥"), // 하트(♥)
	DIAMOND("♦"), // 다이아몬드(♦)
	CLUB("♣"); // 클로버(♣)

	private String icon;

	Suit(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return icon;
	}
}
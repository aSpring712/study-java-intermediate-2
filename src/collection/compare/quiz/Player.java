package collection.compare.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Player
 *
 * @author Kwon Bomi / GitHub: aSpring712
 * @since 2025-05-15
 * @version 1.0
 */
public class Player {

	private String name;
	private List<Card> hand;

	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<>();
	}

	public void drawCard(Deck deck) {
		hand.add(deck.drawCard());
	}

	public int rankSum() {
		int value = 0;
		for (Card card : hand) {
			value += card.getRank();
		}
		return value;
	}

	public void showHand() {
		hand.sort(null);
		System.out.println(name + "의 카드: " + hand + ", 합계: " + rankSum());
	}

	public String getName() {
		return name;
	}
}
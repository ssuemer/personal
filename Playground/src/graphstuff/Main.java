package graphstuff;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import mainPlayground.Card;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] colors = new String[]{"rosen","schellen","eichel","schilten"};
		String[] nums = new String[]{"6","7","8","9","10","under","ober","könig","ass"};
		
		ArrayList<Card> cards = new ArrayList<Card>();
		for (String color : colors) {
			for (String num : nums) {
				cards.add(new Card(color,num));
			}
		}
		
		Collections.shuffle(cards);
		for (Card card : cards) {
			System.out.println(card);
		}
	}

}

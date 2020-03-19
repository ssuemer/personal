package mainPlayground;

public class Card {
	
	private String color;
	private String number;
	
	public Card(String color, String number) {
		this.color = color;
		this.number = number;
	}

	@Override
	public String toString() {
		return "(" + color + "," + number + ")";
	}
	
	
	
	
}

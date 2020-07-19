package mainPlayground;

public class Counter {
	
	int value = 0;

	Counter(int value) {
		System.out.println(value);
		if (value < 1000) {
			new Counter(value + 1);
		}
	}
	
}

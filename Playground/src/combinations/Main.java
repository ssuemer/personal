package combinations;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<int[]> combs = Combinations.generate(1000,501);
		
		for (int[] is : combs) {
			System.out.println(Arrays.toString(is));
		}
		
		
		
	}

}

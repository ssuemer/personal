package mainPlayground;

import java.util.Arrays;

import sorts.AdvancedSorts;
import sorts.PrimitiveSorts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,2,1,4,0,-1};
		AdvancedSorts.<Integer>quickSort(arr);
		PrimitiveSorts.bubbleSort((arr));
		System.out.println(Arrays.toString(arr));
	}
}


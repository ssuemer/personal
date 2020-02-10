package mainPlayground;

import java.util.Arrays;

import sorts.AdvancedSorts;
import sorts.PrimitiveSorts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,2,1,6,0,-1,-3,-6,12,11,7};
		AdvancedSorts.<Integer>naturalMergeSort(arr);
		PrimitiveSorts.bubbleSort((arr));
		System.out.println(Arrays.toString(arr));
	}
}


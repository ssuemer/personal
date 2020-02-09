package mainPlayground;

import java.util.Arrays;

import sorts.AdvancedSorts;
import sorts.PrimitiveSorts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,4,2,6,0,5,1,7};
		AdvancedSorts.mergeSortRecursive(arr);
		System.out.println(Arrays.toString(arr));
	}
}


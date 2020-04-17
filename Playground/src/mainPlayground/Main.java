package mainPlayground;

import java.io.FileNotFoundException;
import java.util.Arrays;

import sorts.PrimitiveSorts;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {1,2,6,3,4};
		PrimitiveSorts.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}


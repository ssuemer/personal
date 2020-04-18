package mainPlayground;

import java.io.FileNotFoundException;
import java.util.Arrays;

import sorts.AdvancedSorts;
import sorts.PrimitiveSorts;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {7,2,3,5,9,11,12,15,18};
		System.out.println(AdvancedSorts.quickSelect(arr, 2));
	}
}


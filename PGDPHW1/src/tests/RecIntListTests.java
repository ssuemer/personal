package tests;

import static org.junit.jupiter.api.Assertions.*;
import mainpack.RecIntList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class RecIntListTests {
	
	Random r = new Random();
	final int L = 1_000;
	final int REP = 10000;
	
	// countThreshold tests
	@Test
	void testCountThresh() {
		for (int i = 0; i < REP; i++) {
			int thresh = r.nextInt();
			int[] expected = generateRandomArray(L);
			RecIntList test = reclist_of_array(expected);
			assertArrayEquals(ctGT(expected, thresh), test.countThresh(thresh));
		}
	}
	
	@Test
	void smallCountThresTest() {
		int[] in = {1, 2, 3, 4, 5};
		int thresh = 3;
		long[] expected = {3, 3, 9};
		long[] res = reclist_of_array(in).countThresh(thresh);
		System.out.println(Arrays.toString(res));
		assertArrayEquals(expected, res);
	}
	
	// kinguinSort tests
	@Test
	void testKinguinSort() {
		boolean inc = false;
		for (int i = 0; i < REP; i++) {
			int[] expectedArr = generateRandomArray(L);
			List<Integer> expected = list_of_array(expectedArr);
			gtKinguinSort(expected, inc);
			RecIntList test = reclist_of_array(expectedArr);
			test.kinguinSort(inc);
			assertArrayEquals(array_of_list(expected), array_of_reclist(test));
		}
	}
	
	@Test
	void smallKinguinSortTest() {
		int[] in = {3, 2, 4, 7, 1, 6, 5, 9, 8};
		int[] expected1 = {3, 4, 7, 9};
		int[] expected2 = {3, 2, 1};
		RecIntList test1 = reclist_of_array(in);
		test1.kinguinSort(true);
		RecIntList test2 = reclist_of_array(in);
		test2.kinguinSort(false);
		assertArrayEquals(expected1, array_of_reclist(test1));
		assertArrayEquals(expected2, array_of_reclist(test2));
	}
	
	// reverse tests
	@Test
	void testReverse() {
		for (int i = 0; i < REP; i++) {
			int[] expectedArr = generateRandomArray(L);
			RecIntList test = reclist_of_array(expectedArr);
			gtReverse(expectedArr);
			test.reverse();
			assertArrayEquals(expectedArr, array_of_reclist(test));
		}
	}
	
	@Test
	void simpleReverseTest() {
		int[] in = {1, 2, 3, 4, 5};
		int[] expected = {5, 4, 3, 2, 1};
		RecIntList test = reclist_of_array(in);
		test.reverse();
		assertArrayEquals(expected, array_of_reclist(test));
	}
	
	// zip tests
	@Test
	void testZip() {
		for (int i = 0; i < REP; i++) {
			int[] arr1 = generateRandomArray(L / 2);
			int[] arr2 = generateRandomArray(L / 2);
			int[] exp = gtZip(arr1, arr2);
			RecIntList test1 = reclist_of_array(arr1);
			RecIntList test2 = reclist_of_array(arr2);
			RecIntList.zip(test1, test2);
			assertArrayEquals(exp, array_of_reclist(test1));
		}
	}
	
	@Test
	void simpleZipTest() {
		int[] arr1 = {1, 3, 5, 7, 8};
		int[] arr2 = {2, 4, 6};
		int[] exp = {1, 2, 3, 4, 5, 6, 7, 8};
		RecIntList test1 = reclist_of_array(arr1);
		RecIntList test2 = reclist_of_array(arr2);
		RecIntList.zip(test1, test2); 
		assertArrayEquals(exp, array_of_reclist(test1));
	}
	
	private int[] array_of_list(List<Integer> l) {
		int[] res = new int[l.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = l.get(i);
		}
		return res;
	}
	
	private List<Integer> list_of_array(int[] arr) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			res.add(arr[i]);
		}
		return res;
	}
	
	private RecIntList reclist_of_list(List<Integer> il) {
		RecIntList l = new RecIntList();
		for (int i : il) {
			l.append(i);
		}
		return l;
	}
	
	private List<Integer> list_of_reclist(RecIntList rl) {
		List<Integer> res = new ArrayList<Integer>();
		int k = rl.size();
		for (int i = 0; i < k; i++) {
			res.add(rl.get(i));
		}
		return res;
	}
	
	private int[] array_of_reclist(RecIntList rl) {
		int[] res = new int[rl.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = rl.get(i);
		}
		
		return res;
	}
	
	private RecIntList reclist_of_array(int[] arr) {
		RecIntList l = new RecIntList();
		for (int i : arr) {
			l.append(i);
		}
		return l;
	}
	
	private int[] generateRandomArray(int N) {
		Random r = new Random();
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			res[i] = r.nextInt();
		}
		
		return res;
	}
	
	// ground truth for countThreshold
	private long[] ctGT(int[] arr, int thresh) {
		long[] res = new long[3];
		for (int x: arr) {
			if (x > thresh)
				res[2] += x;
			else if (x == thresh)
				res[1] += x;
			else
				res[0] += x;
		}
		return res;
	}
	
	// ground truth for kinguinSort
	private void gtKinguinSort(List<Integer> l, boolean increasing) {
		int i = 0;
		if (increasing) {
			while (i < l.size()) {
				while (i + 1 < l.size() && l.get(i + 1) < l.get(i))
					l.remove(i + 1);
				i++;
			}	
		} else {
			while (i < l.size()) {
				while (i + 1 < l.size() && l.get(i + 1) > l.get(i))
					l.remove(i + 1);
				i++;
			}
		}
	}
	
	// ground truth for reverse
	private void gtReverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	// ground truth for zip
	private int[] gtZip(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int k;
		for (k = 0; k < res.length && i < arr1.length && j < arr2.length; k++) {
			if (k % 2 == 0) {
				res[k] = arr1[i];
				i++;
			} else {
				res[k] = arr2[j];
				j++;
			}
		}
		
		while (i < arr1.length) {
			res[k] = arr1[i];
			k++;
			i++;
		}
		
		while (j < arr2.length) {
			res[k] = arr2[j];
			k++;
			j++;
		}
		
		return res;
	}

}

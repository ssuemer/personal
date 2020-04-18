package probability;

import java.util.Random;

import sorts.AdvancedSorts;

public class Median {
	
	private Random randomgen = new Random();
	private Integer[] workon;
	
	public Median(Integer[] workon) {
		if (workon.length % 2 == 0) {
			throw new IllegalArgumentException("Array must be of odd length");
		}
		this.workon = workon;
	}

	public int epsilonmedian(int amount) {
		if (amount % 2 == 0) {
			throw new IllegalArgumentException("Amount must be odd");
		}
		Integer[] b = pick(amount);
		return AdvancedSorts.quickSelect(b, b.length / 2);
	}
	
	public Integer[] pick(int amount) {
		Integer[] result = new Integer[amount];
		for (int i = 0; i < result.length; i++) {
			result[i] = workon[randrange(0,workon.length - 1)];
		}
		return result;
	}
	
	public double calcK(int amount,double epsilon) {
		if (amount % 2 == 0) {
			throw new IllegalArgumentException("Amount must be odd");
		}
		if (epsilon < 0 || epsilon > 1) {
			throw new IllegalArgumentException("Epsilon must be between 0 and 1");
		}
		
		return ((double) amount / workon.length) * Math.floor((1 - epsilon) * workon.length / 2);
	}
	
	public double calcG(int amount,double epsilon) {
		if (amount % 2 == 0) {
			throw new IllegalArgumentException("Amount must be odd");
		}
		if (epsilon < 0 || epsilon > 1) {
			throw new IllegalArgumentException("Epsilon must be between 0 and 1");
		}
		
		return amount * (1 - Math.ceil((1 + epsilon) * workon.length / 2) / workon.length);
	}
	
	private int randrange(int left,int right) {
		if (left > right) {
			throw new IllegalArgumentException("Left border can not be larger!");
		}
		return randomgen.nextInt(right - left + 1) + left;
	}

}

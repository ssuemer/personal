package misc;

import java.util.Scanner;

public class Converter {
	
	public static int binaryToDecimal() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter binary number: ");
		int input = in.nextInt();
		in.close();
		return base1ToDecimal(Integer.toString(input),2);
	}
	
	public static String decimalToHex() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter decimal number: ");
		int input = in.nextInt();
		in.close();
		return decimalToBase2(input,16);
	}
	
	public static String base1ToBase2() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base 1: ");
		int base1 = in.nextInt();
		System.out.print("Enter base 2: ");
		int base2 = in.nextInt();
		System.out.print("Enter number in base 1: ");
		String num = in.next();
		in.close();
		int intermediate = base1ToDecimal(num,base1);
		System.out.println("Intermediate result: " + intermediate);
		return decimalToBase2(intermediate, base2);
	}
	
	private static int base1ToDecimal(String input,int base1) {
		int res = 0;
		int exp = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			String digit = Character.toString(input.charAt(i));
			switch (digit) {
			case "A":
				res += 10 * Math.pow(base1, exp);
				break;
			case "B":
				res += 11 * Math.pow(base1, exp);
				break;
			case "C":
				res += 12 * Math.pow(base1, exp);
				break;
			case "D":
				res += 13 * Math.pow(base1, exp);
				break;
			case "E":
				res += 14 * Math.pow(base1, exp);
				break;
			case "F":
				res += 15 * Math.pow(base1, exp);
				break;
			default:
				res += Integer.parseInt(digit) * Math.pow(base1, exp);
			}
			exp++;
		}
		return res;
	}
	
	private static String decimalToBase2(int decimal,int base2) {
		int i = 1;
		String res = "";
		while (i * base2 <= decimal) {
			i *= base2;
		}
		
		while (i > 0) {
			int c = decimal / i;
			switch (c) {
				case 10:
					res += "A";
					break;
				case 11:
					res += "B";
					break;
				case 12:
					res += "C";
					break;
				case 13:
					res += "D";
					break;
				case 14:
					res += "E";
					break;
				case 15:
					res += "F";
					break;
				default:
					res += c;
			}
			decimal -= c * i;
			i /= base2;
		}
		
		return res;
	}
	
}

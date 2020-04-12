package mainPlayground;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTri(10);
	}
	
	public static void printTri(int n) {
		int[][] DP = new int[n + 1][n + 1];
		for (int i = 0; i < DP.length; i++) {
			DP[i][0] = 1;
			DP[i][i] = 1;
		}
		for (int i = 2; i < DP.length; i++) {
			for (int j = 1; j < i; j++) {
				DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
			}
		}
		
		for (int i = 0; i < DP.length; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(DP[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package misc;

public class HanoiVisual {
	
	private int[][] rods;
	private int n;
	private int pace = 3;
	private boolean displayMode = true;
	
	public HanoiVisual(int n) {
		this.n = n;
	}
	
	public void execute() {
		rods = new int[n][3];
		for (int i = 0; i < n; i++) {
			rods[i][0] = i + 1;
		}
		if (displayMode)
			print();
		solve(0, 2, 1, n);
	}
	
	private void solve(int from, int to, int spare, int n) {
		if (n > 0) {
			solve(from, spare, to, n - 1);
			moveTo(from, to);
			if (displayMode)
				print();
			try {
				Thread.sleep(1000 * pace);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			solve(spare, to, from, n - 1);
		}
	}
	
	private void moveTo(int from, int to) {
		int k = firstDisk(from);
		assert (k >= 0 && k < n) : "No disk on rod:" + rodToChar(from);
		int dSize = rods[k][from];
		rods[k][from] = 0;
		int l = firstDisk(to);
		assert (l <= n && l >= 1 && rods[l - 1][to] == 0) : "Can not place on rod" + rodToChar(to);
		rods[l - 1][to] = dSize;
	}
	
	private int firstDisk(int rod) {
		for (int i = 0; i < n; i++) {
			if (rods[i][rod] != 0) {
				return i;
			}
		}
		return n;
	}
	
	private String rodToChar(int r) {
		switch (r) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		default:
			throw new IllegalArgumentException("No such rod exists");
		}
	}
	
	private boolean allZero(int row) {
		for (int i = 0; i < 3; i++) {
			if (rods[row][i] != 0) {
				return false;
			} 
		}
		return true;
	}
	
	private void print() {
		for (int i = 0; i < rods.length; i++) {
			if (!allZero(i)) {
				String o = rods[i][0] + "-" + rods[i][1] + "-" + rods[i][2];
				System.out.println(o);
			}
		}
		System.out.println();
		System.out.println("-----");
	}
	
	public void setDisplayMode(boolean mode) {
		displayMode = mode;
	}
	
	public int[][] getRods() {
		return rods;
	}
	
	public void setPace(int secs) {
		pace = secs;
	}
}

package mainPlayground;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ds.Queue;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("files\\test1in.txt"));
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			testCase(scanner);
		}
	}	
	
	public static void testCase(Scanner scanner) {
		int n = scanner.nextInt();
		int[] heights = new int[n + 1];
        for (int i = 1;i <= n;i++){
          heights[i] = scanner.nextInt();
        }
        boolean[] enqueued = new boolean[n + 1];
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        enqueued[1] = true;
        while(!q.isEmpty()){
            int cur = q.dequeue();
            int border = (n + 1 < cur + heights[cur]) ? n + 1 : cur + heights[cur];
            for (int i = cur + 1;i < border;i++){
              if (!enqueued[i]){
                q.enqueue(i);
                enqueued[i] = true;
              } 
            } 
          }
	}
}


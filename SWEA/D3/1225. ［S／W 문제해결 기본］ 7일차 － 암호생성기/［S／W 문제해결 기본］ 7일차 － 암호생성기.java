import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = sc.nextInt();
			
			Queue<Integer> queue = new java.util.LinkedList<>();
			
			for(int i=0;i<8;i++)
				queue.add(sc.nextInt());
			
			boolean flag = false;
			while(!flag) {
				for(int i=1;i<=5;i++) {
					if(queue.peek()-i<=0) {
						queue.poll();
						queue.add(0);
						flag=true;
						break;
					}
					queue.add(queue.poll()-i);
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int num : queue)
			System.out.print(num+" ");
            System.out.println();
		}
	}

}

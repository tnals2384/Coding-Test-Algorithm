import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0;t < 10; t++) {
			int N = sc.nextInt();
			
			int[][] ladder = new int[100][100];
			
			for(int i=0;i<100;i++) {
				for(int j = 0;j<100;j++)
					ladder[i][j]= sc.nextInt();
			}
			
			int start = 0;
			for(int i=0;i<100;i++) {
				if(ladder[99][i]==2)
					start = i;
			}
			
			for(int i = 98;i>0;i--) {
				if(start-1 >= 0 && ladder[i][start-1]==1) {
					while(start-1 >= 0  && ladder[i][start-1]!=0)
						start--;
				}
				else if(start+1 <=99 && ladder[i][start+1]==1) {
					while(start+1 <=99 && ladder[i][start+1]!=0)
						start++;
				}
			}
			
			System.out.println("#"+N+" "+start);
		
			
		}
	}
}

import java.util.Arrays;
import java.util.Scanner;

class Solution
{

public static void main(String[] args) throws Exception {
		int T = 10;
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= T;test_case++) {
			int N = sc.nextInt();
			int[] A = new int[100];
			for(int i=0;i<100;i++) {
				A[i]= sc.nextInt();
			}
			
			boolean flag = false;
			int min=1; int max=100;
			for(int i=0;i<=N;i++) {
				Arrays.sort(A);
				min = A[0];
				max = A[99];
				
				if(max-min==0 || max-min==1) {
					System.out.println("#"+test_case+" " + (max-min));
					flag = true;
					break;
				}
                A[0]+=1;
				A[99]-=1;
			}
			if(!flag)
				System.out.println("#"+test_case+" " + (max-min));
		}
	}
}
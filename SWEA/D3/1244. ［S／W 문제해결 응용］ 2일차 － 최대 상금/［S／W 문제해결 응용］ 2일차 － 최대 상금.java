
import java.util.Scanner;

class Solution
{
	static String[] A;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T;test_case++) {
			A = sc.next().split("");
			int N = sc.nextInt();

			max = 0;
			
			if(A.length < N) {
				if(A.length %2 == 1 && N%2==0)
					N= A.length+1;
				else N = A.length;
			}
			dfs(0, N);
			
			
			System.out.println("#"+test_case+" "+max);
		}
		
	}
	public static void dfs(int idx,int N) {
		if(N==0) {
			String number="";
			for(String s : A) {
				number+=s;
			}
			max = Math.max(max, Integer.parseInt(number));

			return;
		}
		
		for(int i = idx ; i < A.length;i++) {
			for(int j = i+1; j< A.length;j++) {
				swap(i,j);
				dfs(i, N-1);
				swap(i,j);
			}
		}
	}
	
	public static void swap(int i, int j) {
		String temp = A[j];
		A[j] = A[i];
		A[i]= temp;
	}
}
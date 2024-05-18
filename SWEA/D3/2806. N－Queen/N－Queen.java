import java.util.Scanner;

public class Solution {
	static int[] A;
	static int answer;
	static int N;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1;test_case<=T;test_case++) { 
			N= sc.nextInt();
			A = new int[N];
			answer=0;
			dfs(0);
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void dfs(int idx) {
		if(idx==N) {
			answer++;
			return;
		}
		
		for(int i=0;i<N;i++) {
			A[idx] = i;
			if(check(idx))
				dfs(idx+1);
		}
			
	}
	
	public static boolean check(int idx) {
		for(int i=0;i<idx;i++) {
			if(A[idx] == A[i] || idx-i == Math.abs(A[idx]-A[i]))
				return false;
		}
		return true;
	}
}

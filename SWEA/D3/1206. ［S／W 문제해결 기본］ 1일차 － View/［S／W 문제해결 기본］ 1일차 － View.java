
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			int answer = 0;
			int[] building = new int[N];
			for(int i=0;i<N;i++) {
				building[i] = Integer.parseInt(sc.next());
			}
			
			for(int i=2;i<N-2;i++) {
				int max = 0;
				for(int j = -2; j<=2; j++) {
					if(j==0) continue;
					max = Math.max(max, building[i+j]);
				}
				if( max > building[i]) {
					continue;
				}
				answer += building[i] - max;
				
			}
			System.out.println("#"+test_case+ " "+ answer);
		}
	}
}
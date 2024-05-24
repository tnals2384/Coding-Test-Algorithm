import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i]=sc.nextInt();

        
        int max= 0;
        int[] dp = new int[N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(A[j] > A[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max+1);
    }
}

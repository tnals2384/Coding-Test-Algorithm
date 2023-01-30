import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();
        int[] A =new int[N];
        int[] dp =new int[N];

        for(int i=0; i<N;i++) {
            A[i]=sc.nextInt();
            dp[i]=1;
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(A[i]>A[j])
                     dp[i]=Math.max(dp[i],dp[j]+1);
            }

        }
        Arrays.sort(dp);

        System.out.println(dp[N-1]);
    }
}

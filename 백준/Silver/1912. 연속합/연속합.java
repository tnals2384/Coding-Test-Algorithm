import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A= new int[N];
        int[] dp = new int[N];

        for(int i=0;i<N;i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=A[0];
        int max=dp[0];
        for(int i=1; i<N;i++) {
            dp[i] =Math.max(dp[i-1]+A[i],A[i]);
            max= Math.max(dp[i],max);

        }
        System.out.println(max);
    }
}

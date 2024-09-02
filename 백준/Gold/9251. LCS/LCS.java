import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s1 = br.readLine().split("");
        String[] s2 = br.readLine().split("");

        int[][] dp = new int[s1.length + 1][s2.length + 1];
        
        //2차원 배열을 생성해서 최장 부분 수열 count
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1].equals(s2[j - 1]))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[s1.length][s2.length]);

    }
}

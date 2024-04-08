import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] bus = new long[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            Arrays.fill(bus[i], Integer.MAX_VALUE);
            bus[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(bus[a][b] > c)
                bus[a][b] = c;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    bus[j][k] = Math.min(bus[j][k], bus[j][i] + bus[i][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (bus[i][j] == Integer.MAX_VALUE)
                    bw.write(0 + " ");
                else bw.write(bus[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
    }
}

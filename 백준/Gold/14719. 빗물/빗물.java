import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /**
     * 세로 가로 H , W
     * 높이 W개
     * 블록 내부의 빈공간 X
     * 바닥은 항상 막혀있음
     * 고이는 빗물의 총량을 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] rain = new ArrayList[H + 1];
        for (int i = 1; i <= H; i++) {
            rain[i] = new ArrayList<>();
        }

        int maxH = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            int h = Integer.parseInt(st.nextToken());
            maxH = Math.max(maxH, h);
            for (int j = 1; j <= h; j++) {
                rain[j].add(i);
            }
        }

        int answer = 0;
        for (int i = 1; i <= maxH; i++) {
            for (int j = 1; j < rain[i].size(); j++) {
                int d = rain[i].get(j) - rain[i].get(j - 1) - 1;
                if (d > 0) {
                    answer += d;
                }
            }
        }

        System.out.println(answer);
    }
}

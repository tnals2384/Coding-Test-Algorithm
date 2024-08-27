import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        A = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        dfs("", 0, 0);
    }

    public static void dfs(String s, int idx, int d) {
        if (d == M) {
            System.out.println(s.substring(1));
            return;
        }

        for (int i = idx; i < A.length; i++) {

            dfs(s + " " + A[i], i, d + 1);
        }
    }

}

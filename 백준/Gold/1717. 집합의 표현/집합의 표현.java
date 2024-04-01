import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            A[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (c.equals("0")) {
                union(a, b);
            } else {
                a = find(a);
                b = find(b);
                if (a == b)
                    System.out.println("YES");
                else System.out.println("NO");
            }

        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            A[b] = a;
    }

    //index값과 value값이 같을 때까지 실행 후
    //거치는 모든 노드 값을 루트 노드값으로 변경
    private static int find(int a) {
        if (a == A[a])
            return a;
        else return A[a] = find(A[a]);
    }
}

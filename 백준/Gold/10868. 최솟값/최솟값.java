import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int k = 0;
        while (true) {
            if (Math.pow(2, k) < N)
                k++;
            else break;
        }

        int treeSize = (int) Math.pow(2, k + 1);
        tree = new int[treeSize];
        int start = treeSize / 2 - 1;

        for (int i = start + 1; i <= start + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(findMin(start + a, start + b));
        }


    }

    public static void setTree(int idx) {
        while (idx > 1) {
            tree[idx / 2] = Math.min(tree[idx], tree[idx - 1]);
            idx -= 2;
        }
    }

    public static int findMin(int a, int b) {
        int min = Integer.MAX_VALUE;

        while (a <= b) {
            if (a % 2 == 1)
                min = Math.min(min, tree[a]);

            if (b % 2 == 0)
                min = Math.min(min, tree[b]);

            a = (a + 1) / 2;
            b = (b - 1) / 2;
        }
        return min;
    }
}

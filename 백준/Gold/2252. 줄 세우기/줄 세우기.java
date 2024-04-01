import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<Integer>[] A;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        D = new int[N + 1];

        A = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<Integer>();


        for (int i = 0; i < M; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            A[a].add(b);
            D[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (D[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int n : A[now]) {
                D[n]--;
                if (D[n] == 0)
                    queue.add(n);
            }
        }


    }
}

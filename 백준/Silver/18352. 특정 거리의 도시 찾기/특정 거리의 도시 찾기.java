import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] A = new ArrayList[N + 1];
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            A[s].add(e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        distance[X] = 0;
        visited[X] = true;

        while (!q.isEmpty()) {
            int n = q.poll();

            for (Integer x : A[n]) {
                if (!visited[x]) {
                    q.add(x);
                    visited[x] = true;
                    distance[x] = distance[n] + 1;
                }
            }
        }

        boolean x = false;
        for (int i = 1; i < N + 1; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                x = true;
            }
        }
        if (!x)
            System.out.println(-1);


    }
}

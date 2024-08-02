import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            list[x].add(y);
            list[y].add(x);
        }

        //정렬
        for (int i = 1; i <= N; i++)
            Collections.sort(list[i]);

        visited = new boolean[N + 1];
        visited[V] = true;
        System.out.print(V + " ");
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int s) {

        for (int i : list[s]) {
            if (visited[i]) continue;
            visited[i] = true;
            System.out.print(i + " ");
            dfs(i);
        }
    }

    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        System.out.print(V + " ");
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : list[now]) {
                if (visited[i]) continue;
                visited[i] = true;
                System.out.print(i + " ");
                queue.add(i);
            }
        }
    }
}

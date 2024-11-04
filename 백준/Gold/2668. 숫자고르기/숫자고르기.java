import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] A;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());
            A[i] = x;
        }


        //사이클 판단
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            find(visited, i, A[i]);
            visited[i] = false;
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void find(boolean[] visited, int s, int i) {
        if (!visited[i]) {
            visited[i] = true;
            find(visited, s, A[i]);
            visited[i] = false;
        }

        if (s == i) list.add(i);
    }
}

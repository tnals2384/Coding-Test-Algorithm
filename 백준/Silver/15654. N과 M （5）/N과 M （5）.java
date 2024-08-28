import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int M;
    static int N;
    static int[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        //조합을 출력하기


        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        dfs("",0);
    }

    public static void dfs(String s, int d) {
        if (d == M) {
            System.out.println(s.substring(1));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i]= true;
            dfs(s + " " + A[i], d + 1);
            visited[i] = false;
        }
    }
}

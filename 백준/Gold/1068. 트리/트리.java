import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static int count;
    static int remove;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N];
        for (int i = 0; i < N; i++)
            A[i] = new ArrayList<>();

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int parent = Integer.parseInt(st. nextToken());
            if(parent==-1)
                root = i;
            else A[parent].add(i);
        }

        remove = Integer.parseInt(br.readLine());

        if(remove != root)
            dfs(root);

        System.out.println(count);
    }

    public static void dfs(int s) {
        boolean parent = false;
        for(int now : A[s]) {
            if(now != remove) {
                dfs(now);
                parent = true;
            }
        }
        if (!parent)
            count++;
    }
}

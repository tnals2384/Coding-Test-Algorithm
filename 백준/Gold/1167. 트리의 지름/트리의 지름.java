import java.io.*;
import java.util.*;

public class Main {

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    static boolean[] visited;
    static int N;
    static ArrayList<Node>[] A;
    static int node;
    static int max;

    public static class Node {
        int x;
        int d;

        public Node(int x, int d ){
            this.x = x;
            this.d = d;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        A  = new ArrayList[N+1];
        for(int i=0;i<N+1;i++)
            A[i] = new ArrayList<Node>();

        visited = new boolean[N+1];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = stoi(st.nextToken());
            while (true) {
                int y = stoi(st.nextToken());
                if (y == -1) {break;}

                int d = stoi(st.nextToken());
                A[x].add(new Node(y, d));

            }
        }


        dfs(1,0);
        visited = new boolean[N+1];
        dfs(node,0);

        System.out.println(max);

    }
    public static void dfs(int start,int count) {
        if(max < count) {
            node = start;
            max = count;
        }
        visited[start] = true;
        for(int i=0;i<A[start].size();i++) {
            Node node = A[start].get(i);
            if(!visited[node.x]) {
                dfs(node.x,count+node.d);
            }
        }
    }
}

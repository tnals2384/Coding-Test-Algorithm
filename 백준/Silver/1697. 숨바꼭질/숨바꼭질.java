import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Node {
        int X;
        int count;

        public Node(int X, int count) {
            this.X = X;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        visited[N] = true;
        queue.add(new Node(N,0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.X]=true;

            if (now.X ==K) {
                System.out.println(now.count);
                return;
            }

            if (now.X - 1 >= 0 && !visited[now.X-1]) {
                queue.add(new Node(now.X - 1, now.count+1));
                visited[now.X - 1] = true;
            }
            if (now.X + 1 <= 100000 && !visited[now.X+1]) {
                queue.add(new Node(now.X + 1, now.count+1));
                visited[now.X + 1] = true;
            }
            if (now.X * 2 <= 100000 && !visited[now.X*2]) {
                queue.add(new Node(now.X *2, now.count+1));
                visited[now.X * 2] = true;
            }
        }
    }
}

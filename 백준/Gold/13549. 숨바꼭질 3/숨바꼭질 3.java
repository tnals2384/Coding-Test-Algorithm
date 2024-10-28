import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Point {
        int x;
        int d;

        public Point(int x, int d) {
            this.x = x;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(s, 0));
        boolean[] visited = new boolean[100001];
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.x] = true;
            if (p.x == e) {
                min = Math.min(min, p.d);
                continue;
            }

            if (p.x - 1 >= 0 && !visited[p.x - 1])
                queue.add(new Point(p.x - 1, p.d + 1));
            if (p.x + 1 <= 100000 && !visited[p.x + 1])
                queue.add(new Point(p.x + 1, p.d + 1));
            if (p.x * 2 <= 100000 && !visited[p.x * 2])
                queue.add(new Point(p.x * 2, p.d));
        }

        System.out.println(min);
    }
}

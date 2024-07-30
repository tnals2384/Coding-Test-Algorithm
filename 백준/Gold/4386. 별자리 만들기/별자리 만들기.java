import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Edge {
        private int i;
        private double w;

        public Edge(int i, double w) {
            this.i = i;
            this.w = w;
        }
    }

    //얘는 노드가 주어짐 -  프림
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Double[][] star = new Double[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star[i][0] = x;
            star[i][1] = y;
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.w));
        pq.add(new Edge(0, 0));
        double cost = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.i]) continue;

            visited[edge.i] = true;
            cost += edge.w;

            for (int i = 0; i < N; i++) {
                if(visited[i]) continue;
                double result = Math.sqrt(Math.pow(star[edge.i][0] - star[i][0], 2) + Math.pow(star[edge.i][1] - star[i][1], 2));
                pq.add(new Edge(i, result));
            }
        }

        System.out.printf("%.2f%n",cost);
    }

}

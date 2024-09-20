import java.util.*;
class Solution {
    public class Edge {
        int s;
        int e;
        int w;
        
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    
    public int[] uf;
    //크루스칼 알고리즘 MST
    public int solution(int n, int[][] costs) {
        
        //union find 초기화
        uf = new int[n];
        for(int i=0;i<n;i++) {
            uf[i] = i;
        }
        
        ArrayList<Edge> list = new ArrayList<>();
        
        for(int[] cost : costs) {
            list.add(new Edge(cost[0], cost[1], cost[2]));
        }
        
        //1. cost 기준 오름차순
        list.sort(Comparator.comparingInt(e -> e.w));
        
        int cnt = 0;
        int total = 0;

        for(Edge edge : list) {
            if(find(edge.s) != find(edge.e)) {
                union(find(edge.s), find(edge.e));
                total += edge.w;
            }
        }
        
        return total;
    }
    
    public int find(int x) {
        if(uf[x] == x)
            return x;
        
        return uf[x] = find(uf[x]);
    }
    
    public void union(int a, int b) {
        if(find(a) != find(b))
            uf[b] = a;
    }
}
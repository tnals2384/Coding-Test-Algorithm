import java.util.*;
class Solution {
    int[] uf;
    public class Edge {
        int a;
        int b;
        int w;
        
        public Edge(int a,int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
       
        Arrays.sort(costs, Comparator.comparing((int[] o) -> o[2]));
        uf = new int[n];
        
        for(int i=0;i<n;i++)
            uf[i] = i;
        
        int count=0;
        while(count < n-1) {
            for(int[] cost : costs) {
                int a = find(cost[0]);
                int b = find(cost[1]);
                if(a!=b) {
                    union(a,b);
                    answer+=cost[2];
                    count++;
                }
            }
        }
        
        return answer;
    }
    
    public int find(int a) {
        if(a==uf[a])
            return a;
        else return uf[a]=find(uf[a]);
    }
    
    public void union(int a, int b) {
        if(find(a) != find(b))
            uf[b]=a;
    }
}
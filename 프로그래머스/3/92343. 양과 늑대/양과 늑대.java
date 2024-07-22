import java.util.*;

class Solution {

    static int sheep = 0;
    static ArrayList<Integer>[] child;
    public int solution(int[] info, int[][] edges) {

        child = new ArrayList[info.length];
        for(int i = 0 ; i < info.length; i++) {
            child[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length ; i++) {
            child[edges[i][0]].add(edges[i][1]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,0,0,info,list);
        
        return sheep;
    }
    
    public static void dfs(int i, int w, int s, int[] info, ArrayList<Integer> list) {

        if(info[i]==0)  {
            s++;
        }
        else w++;
        
        if(s <= w) 
            return;
        
        sheep = Math.max(sheep, s);
        ArrayList<Integer> next = new ArrayList<>(list);
        next.remove(Integer.valueOf(i));
        
        for(int c : child[i]) {
            next.add(c);
        }
        
        for(int n : next) {
            dfs(n, w, s, info, next);
        }
    }
}
class Solution {
    boolean[] visited;
    int max= -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0, 0);
        return max;
    }
    
    public void dfs(int[][] dungeons, int k, int d, int count) {
        if(d == dungeons.length) {
            max = Math.max(max, count);
            return;
        }
        
        for(int i=0; i < dungeons.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            if(dungeons[i][0] <= k) {
                dfs(dungeons, k-dungeons[i][1], d+1, count+1);
            } else {
                dfs(dungeons, k, d+1,count);
            }
            visited[i] = false;
            
        }
    }
}
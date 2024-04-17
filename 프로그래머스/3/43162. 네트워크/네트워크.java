class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i,computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int s, int[][] computers) {
        visited[s] = true;
        for(int i = 0; i < computers.length; i++) {
            
            if(computers[s][i] == 1) {
                if(s == i || visited[i])
                    continue;

                visited[i] = true;
                dfs(i, computers);
            }
        }
    }
}
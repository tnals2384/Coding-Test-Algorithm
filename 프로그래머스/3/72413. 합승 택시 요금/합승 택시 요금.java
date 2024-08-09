class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] cost = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n ; j++) {
                if(i!=j)
                    cost[i][j] = 20000001;
            }
        }
        
        for(int[] fare : fares) {
            cost[fare[0]][fare[1]] = fare[2];
            cost[fare[1]][fare[0]] = fare[2];
        }
        
        for(int k = 1; k <= n; k++) { //경로를 k로 두기
            for(int i = 1; i <= n; i++) { //시작
                for(int j = 1; j <= n; j++) { //끝
                    cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
                }
            }
        }
        
        answer = cost[s][a] + cost[s][b]; //각자 가는 방법

        //합승하는 방법
        for(int k = 1; k <= n; k++)
            answer = Math.min(answer, cost[s][k] + cost[k][a] + cost[k][b]);
        
        return answer;
    }
}
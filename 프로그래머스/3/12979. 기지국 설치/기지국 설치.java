class Solution {
    public int solution(int N, int[] stations, int w) {
        int answer = 0;
        int p = w * 2 + 1;
        int[] impossible = new int[stations.length+1];
        
        for(int i = 0 ;i<=stations.length;i++) {
            if(i==0) {
                impossible[i] = (stations[i] - w) - 1;
            }
            else if(i==stations.length) {
                impossible[i] = N - (stations[i-1] + w);
            }
            else
                impossible[i] = (stations[i]-w) - (stations[i-1] + w) -1 ;
        }
        
        for(int i = 0 ; i<=stations.length;i++) {
            if(impossible[i] <= 0) continue;
            if(impossible[i] % p == 0)
                answer += impossible[i]/p;
            else
                answer += impossible[i]/p +1;
        }
        
        
        return answer;
    }
}
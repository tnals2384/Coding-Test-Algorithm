class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
 
   
        int now = 1;
        int i = 0;
        while(now <= n) {
            if(i< stations.length && now >= stations[i] - w) {
                now = stations[i]+w+1;
                i++;
            }
            else {
                answer++;
                now+= w*2+1;
            }
        }
        
        return answer;
    }
}
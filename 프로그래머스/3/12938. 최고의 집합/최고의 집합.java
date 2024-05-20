class Solution {
    public int[] solution(int n, int s) {
        
        if(s < n) {
            int[] answer = {-1};
            return answer;
        }
            
        
        int x = s / n;
        int m = s % n;
        
        int[] answer = new int[n];
        // m개의 x+1, n-m개의 x
        for(int i=0;i<n-m;i++) 
            answer[i] = x;
        
        for(int i=n-m;i<n;i++)
            answer[i] = x+1;
        
        
        
  
        return answer;
    }
}
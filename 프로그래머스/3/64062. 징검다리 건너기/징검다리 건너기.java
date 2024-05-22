class Solution {
     public int solution(int[] stones, int k) {
         int answer=0;
         int min = 1;
         int max= 200000000;
         
         while(min <= max) {
             int mid = (min+max) / 2 ;
             
             if(check(stones, k, mid)) {
                 min = mid+1;
                 answer = min;
             }
             else
                 max = mid-1;
         }
         return answer;
         
    }
    
    public boolean check(int[] stones, int k, int now) {
        int count=0; 
        for(int i=0;i<stones.length;i++) {
                if(stones[i] <= now)
                    count++;
                else count=0;
                
                if(count==k)
                    return false;
            }
            return true;
    }
}
class Solution {
     public int solution(int[] stones, int k) {
         int answer=0;
         int min = 1;
         int max= 200000000;
         
         while(min < max) {
             int mid = (min+max) / 2 ;
             
             if(check(stones, k, mid)) {
                 min = mid + 1;
             }
             else
                 max = mid;
         }
         return max;
         
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
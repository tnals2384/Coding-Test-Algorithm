class Solution {
    public int solution(int[] a) {
        int answer = 2;
    
        //양 옆에서 가장 작은 수를 뽑고
        //해당 수가 그 두 수보다 클 경우 false
        //두 수 중 하나보다 작으면 true
        int[] min1 = new int[a.length];
        int[] min2 = new int[a.length];
        int l = a[0];
        int r = a[a.length-1];
        for(int i=1; i < a.length; i++) {
            min1[i] = Math.min(a[i],l);
            l = min1[i];
        }
        
        for(int i= a.length-2 ; i>0; i--) {
            min2[i] = Math.min(a[i],r);
            r = min2[i];
        }
        
        if(a.length==1) return 1;
        
        for(int i=1;i < a.length-1; i++) {
            if(min1[i] >= a[i] || min2[i] >= a[i])
                answer++;
   
        }
        
        return answer;
    }
}
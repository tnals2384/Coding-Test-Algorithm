class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
       
        for(int i=1;i<=total/2;i++) {
            if(total % i == 0) {
                int c = i;
                int r = total / i;
                
                if((r-2)*(c-2) == yellow) {
                    answer[0] = r;
                    answer[1] = c;
                    break;
                }
                    
            }
        }
        return answer;
    }
}
class Solution
{
    public int solution(String s) {
        int answer = 1;

        for(int i = s.length()-1; i > 0 ; i--) {
            for(int j = 0; j+i < s.length(); j++) {
                int start = j; 
                int end = i + j;
              
                while(start < end) {
                    if(s.charAt(start) == s.charAt(end)) {
                        start++;
                        end--;
                    }
                    else break;
                }
                
                if(start >= end)
                    return i+1;
            }
        }
        return answer;
    }
}
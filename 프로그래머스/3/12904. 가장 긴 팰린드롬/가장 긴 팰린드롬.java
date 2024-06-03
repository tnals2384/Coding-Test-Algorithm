class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        for(int i=s.length(); i > 0; i--) {
            for(int j=0; j + i < s.length(); j++) {
                int start = j;
                int end = j + i;
                boolean flag = false;
                
                while(start < end) {
                    if(s.charAt(start) != s.charAt(end)) {
                        flag = true;
                        break;
                    }
                    start++;
                    end--;
                }
                
                if(!flag)
                    return i+1;
            }
        }

        return answer;
    }
}
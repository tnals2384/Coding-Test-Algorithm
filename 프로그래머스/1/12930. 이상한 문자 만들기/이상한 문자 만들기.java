class Solution {
    public String solution(String s) {
        String answer = "";
      
        String[] str = s.toUpperCase().split("");
        int count = 0;
        for(String ch : str) {
            if(ch.equals(" "))
                count = 0;
            else
                count += 1;
            
            if(count%2 == 1) answer += ch ;
            else answer += ch.toLowerCase();
        }
        
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        String x="";
        int X=0;
        int notX=0;
        int answer = 0;
        boolean start=true;
        for(int i=0;i<s.length();i++) {
            
            if(start) {
                answer++;
                x=s.substring(i,i+1);
                X++;
                start=false;
            }
            else {
                if(s.substring(i,i+1).equals(x)) {
                    X++;
                }
                else {
                    notX++;
                }
            }
            if(X==notX) {
                start=true;
            }

        }
        
        return answer;
    }
}
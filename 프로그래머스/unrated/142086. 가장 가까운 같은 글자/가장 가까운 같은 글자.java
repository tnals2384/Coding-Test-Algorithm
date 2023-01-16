class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        StringBuilder str= new StringBuilder();
        
        for(int i=0;i < s.length();i++) {
            if(!str.toString().contains(s.substring(i,i+1))) {
                answer[i]= -1;
                str.append(s.charAt(i));
            }
            else {
                int index=str.lastIndexOf((s.substring(i,i+1)));
                answer[i] = i-index;
                str.append(s.charAt(i));
            }
        } 
        
        return answer;
    }
}
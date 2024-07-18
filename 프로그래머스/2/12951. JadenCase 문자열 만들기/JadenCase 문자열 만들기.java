class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String s2 = s.toLowerCase();
        char last = ' ';
        
        for(char c : s2.toCharArray()) {
            if(last == ' ') c = Character.toUpperCase(c); //앞이 공백일때만 대문자로 바꿔준다.
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }
}
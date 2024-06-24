class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        //n진법, t개 숫자만큼 구해야함, 게임에 m명 참가할 때, 튜브는 p번째로 말함
        
        // t개만큼 구해야되니깐,, m*t만큼 n진법으로 변환해서 스트링으로 이어붙여야함
        String str = "";
        String temp = "0123456789ABCDEF";
        
        for(int i=0;i<=m*t;i++) {
            str += Integer.toString(i, n).toUpperCase();
        }
        
        for(int i=p-1; t > answer.length(); i+=m) {
            answer+=str.charAt(i);
        }
        return answer;
    }
}
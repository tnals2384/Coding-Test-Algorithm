class Solution {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        int p=0,y=0;
        for(int i=0; i< s.length();i++) {
            if(s.charAt(i)=='p')
                p++;
            if(s.charAt(i)=='y')
                y++;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        if(p==y) answer=true;
        else answer=false;

        return answer;
    }
}
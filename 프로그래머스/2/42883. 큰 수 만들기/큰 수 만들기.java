import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        int start = 0;
        
        for(int i=0; i < len - k; i++) {
            int max = 0;
            for(int j = start; j <= k + i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    start = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
     
        int length = citations.length;
        int idx = 0;
        while(idx < length) {
            if(length - idx <= citations[idx]) {
                answer = length - idx;
                break;
            }
            idx++;
        }

        return answer;
    }
}
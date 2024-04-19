import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparing((int[] o) -> o[1]));
        int i=0;

        int end = Integer.MIN_VALUE;
        for(int[] route : routes) {
            if(end < route[0]) {
                end = route[1];
                answer++;
            }
        }
        return answer;
    }
}
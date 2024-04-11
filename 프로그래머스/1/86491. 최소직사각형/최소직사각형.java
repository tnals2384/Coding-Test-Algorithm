import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int len = sizes.length;
        int[] min = new int[len];
        int[] max = new int[len];
        
        for(int i=0;i<len;i++) {
            min[i] = Math.min(sizes[i][0],sizes[i][1]);
            max[i] = Math.max(sizes[i][0],sizes[i][1]);
        }
        Arrays.sort(min);
        Arrays.sort(max);
        return min[len-1]*max[len-1];
    }
}
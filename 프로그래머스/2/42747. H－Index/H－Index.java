import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int length = citations.length;
        
         Integer[] A = Arrays.stream(citations)
                                       .boxed() 
                                       .toArray(Integer[]::new);
        Arrays.sort(A, (a, b) -> b - a);
    
        
        for(int i = 0; i < length; i++) {
            if(A[i] > length) continue;
            
            if(i + 1 > A[i]) 
                return i;
        }

        return length;
    }
}
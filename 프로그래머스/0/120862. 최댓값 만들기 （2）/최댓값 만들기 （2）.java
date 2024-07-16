import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int n = numbers.length;
        Arrays.sort(numbers);
        
        int n1 = numbers[0]*numbers[1];
        int n2 = numbers[n-2]*numbers[n-1];
        
        return Math.max(n1,n2);
    }
}
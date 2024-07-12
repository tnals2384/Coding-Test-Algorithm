import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n==1 || n==2) return 1;
        
        // 나누기 2 해서 나머지 1이 나오는만큼 더하기
        while(n > 0) {
            if(n % 2 == 1) ans+=1;
            n /= 2;
        }

        return ans;
    }
}
import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        
        for(int i=0;i<9;i++) 
            dp.add(new HashSet<>());
        
        dp.get(1).add(N);
        if(N==number)
            return 1;
        for(int i=2; i<9; i++) {
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for(int j = 1; j < i; j++) {
                for(int num1 : dp.get(i-j)) {
                    for(int num2 : dp.get(j)) {
                        int plus = num1 + num2;
                        int minus = num1 - num2;
                        int mul = num1 * num2;
                        if(num2 != 0) {
                            int div = (int) (num1 / num2);
                            dp.get(i).add(div);
                        }
                        dp.get(i).add(plus);
                        dp.get(i).add(mul);
                        if(minus >= 0)
                            dp.get(i).add(minus);
                    }
                }
            }
            for(int num : dp.get(i)) {
                if( num == number)
                    return i;
            }
        }
        
        return -1;
    }
}
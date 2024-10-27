class Solution {
    //블록에 적힌 번호가 n일때 가장 첫 블록은 2n 위치에 설치 다음은 3n, 4n
    //블록은 1이 적힌 블록부터 숫자를 1씩 증가시키며
    
    public int[] solution(long begin, long end) {
        int[] A = new int[(int) (end - begin + 1)];
        int idx = 0;
        
        for(int i = (int) begin; i<= (int) end; i++, idx++) {
            if(i == 1) {
                A[idx] = 0;
                continue;
            }
            
            int result = 1;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) { 
                    if (i / j <= 10000000) {  
                        result = i / j;
                        break; 
                    } else {
                        result = j;  
                    }
                }
            }
            A[idx] = result;
        }
        
        return A;
    }
}
class Solution {
    public int count = 0;
    
    public int solution(int n) {
        int[] A = new int[n];
        perm(n, 0, A);
        return count;
    }
    
    public void perm(int n, int d, int[] A) {
        if (d == n) {
            count++;
            return;
        }
        
        //3 1 5 2 4
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            
            for (int j = 0; j < d; j++) {
                if (A[j] == i || Math.abs(A[j] - i) == Math.abs(j - d)) {
                    isValid = false;
                    break;
                }
            }
            
            if (!isValid) continue;
            
            A[d] = i; 
            perm(n, d + 1, A);
        }
    }
}

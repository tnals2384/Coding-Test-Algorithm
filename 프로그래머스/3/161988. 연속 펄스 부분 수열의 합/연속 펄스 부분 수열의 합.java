class Solution {
    long max = Long.MIN_VALUE;
    public long solution(int[] sequence) {
        max = Math.max(sequence[0],-sequence[0]);
        pulse(sequence, -1);
        pulse(sequence, 1);
        
        return max;
    }
    public void pulse(int[] sequence, int sign) {
        long[] A = new long[sequence.length];
        A[0] = sign*sequence[0];
        for(int i=1; i < sequence.length; i++) {
            sign *= -1;
            A[i] = Math.max(sign*sequence[i], A[i-1] + sign*sequence[i]);
            max = Math.max(max, A[i]);
        }
        
    }
}
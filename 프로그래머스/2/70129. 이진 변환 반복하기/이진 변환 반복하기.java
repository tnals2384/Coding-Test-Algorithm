class Solution {
    int count;
    int depth;
    public int[] solution(String s) {
        int[] answer = new int[2];
        change(s);
        
        answer[0] =depth;
        answer[1] = count;
        
        return answer;
    }
    
    public void change(String number) {
        int one = 0;
        for(int i=0;i<number.length();i++) {
            if(number.charAt(i)=='1') one++;
        }
        
        depth++;
        count += number.length()-one;
        
        if(one==1) return;
 
        change(Integer.toBinaryString(one));
        
    }
}
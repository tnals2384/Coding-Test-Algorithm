class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int depth, int num, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(num == target)
                answer++;
            return;
        }
        
        for(int i=0;i<2;i++) {
            if(i==0)
                dfs(depth+1, num+numbers[depth], numbers, target);
            else
                dfs(depth+1, num-numbers[depth], numbers, target);
        }
        
    }
}
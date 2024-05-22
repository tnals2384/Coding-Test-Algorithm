class Solution {
    public int solution(int sticker[]) {
       if(sticker.length==1)
            return sticker[0];

        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];

        //첫번째 거 고를경우 마지막거 못고름
        for(int i=2; i<sticker.length-1;i++) {
            dp[i]= Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int answer = dp[sticker.length-2];

        dp[0]= 0;
        dp[1]= sticker[1];
        //두번째거 고를경우 마지막거 고를 수 있음
        for(int i=2;i<sticker.length;i++) {
            dp[i]= Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }

        answer = Math.max(answer, dp[sticker.length-1]);


        return answer;
    }
}
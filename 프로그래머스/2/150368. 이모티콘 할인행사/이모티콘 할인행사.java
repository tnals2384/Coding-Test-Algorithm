class Solution {
 
    int totalCount = -1;
    int totalAmount = -1;
    int[] discount = {40, 30, 20, 10};
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] sum = new int[users.length];
        func(0, users, emoticons, sum);
   
        return new int[]{totalCount, totalAmount};
    }
    
    public void func(int idx, int[][] users, int[] emoticons, int[] sum) {
        
        if(idx >= emoticons.length) {
            update(users, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int[] newsum = sum.clone();
            for(int j = 0; j < users.length; j++) {
                if(users[j][0] <= discount[i]) {
                    //사야댐
                    int price = emoticons[idx] - (int) (emoticons[idx] * discount[i] * 0.01);
                    newsum[j] += price;
                } 
            }
            
            func(idx+1, users, emoticons, newsum);
        }
    }
    
    public void update(int[][] users, int[] sum) {
        int count = 0;
        int amount = 0;
        
        for(int i = 0; i < users.length; i++) {
            if (users[i][1] <= sum[i]) {
                count++;
            } else {
                amount += sum[i];
            }
        }
        
        if(count > totalCount) {
            totalCount = count;
            totalAmount = amount;
        } else if(count == totalCount) {
            totalAmount = Math.max(amount, totalAmount);
        }
    }
}
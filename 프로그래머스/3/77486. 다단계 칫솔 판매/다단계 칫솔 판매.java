import java.util.*;

class Solution {
    HashMap<String, Integer> profit;
    HashMap<String, String> ref;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        profit = new HashMap<>();
        ref = new HashMap<>();
        for(int i=0; i< enroll.length; i++) {
            if(!referral[i].equals("-")) 
                ref.put(enroll[i], referral[i]);  
            profit.put(enroll[i],0);
        }
        
        for(int i=0; i< seller.length;i++) {
            calculate(seller[i], amount[i]*100);
            
        }
        
        for(int i=0; i< enroll.length;i++) {
            answer[i] = profit.get(enroll[i]);
        }
        return answer;
    }
    
    public void calculate(String name, Integer amount) {
        int referralAmount = (int) (amount*0.1);
        int myAmount = amount - referralAmount;
        
        profit.put(name, profit.get(name) + myAmount); 
        if(!ref.containsKey(name))
            return;
        
        if(referralAmount < 1)
            return;
        
        calculate(ref.get(name), referralAmount);
    }
}
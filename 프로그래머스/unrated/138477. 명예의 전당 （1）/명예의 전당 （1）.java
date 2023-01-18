import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer =  new int[score.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i< score.length;i++) {
            
            list.add(score[i]);
            Collections.sort(list);
            
            if(i < k) 
                answer[i]=list.get(0);
            else answer[i]=list.get(list.size()-k);
        }

        return answer;
    }
}
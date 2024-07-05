import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        ArrayList<Integer> sum = new ArrayList<>();
        
        //내림차순, 오름차순
        Arrays.sort(scores, (o1,o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        int max = scores[0][1];
        for(int[] score : scores) {
            if(score[1] < max) {
                if(score[0] == wanho[0] && score[1] == wanho[1])
                    return -1;
            }
            else {
                max = score[1];
                sum.add(score[0]+score[1]);
            }
        }
        
        Collections.sort(sum, Comparator.reverseOrder());
        return sum.indexOf(wanho[0]+wanho[1])+1;
    }
}
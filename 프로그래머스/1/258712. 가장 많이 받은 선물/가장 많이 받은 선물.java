import java.util.*;
class Solution {
    //A는 선물을 준 친구 B는 선물 받은 친구
    //선물지수 : 준 선물 - 받은 선물 
    //더많은 선물을 준사람이 하나 받음
    // 선물 주고받은 적 없거나 같은 수로 주고받았으면 선물지수가 큰사람이 선물 지수가 작은 사람에게 하나 받음
    
    public int solution(String[] friends, String[] gifts) {
        int max = 0;
        
        HashMap<String, Integer> name = new HashMap<>();
        for(int i = 0; i < friends.length; i++) {
            name.put(friends[i], i);
        }
        
        int[][] board = new int[friends.length][friends.length];
        int[] value = new int[friends.length];
        
        for(int i = 0; i < gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            board[name.get(s[0])][name.get(s[1])]++;
            value[name.get(s[0])]++;
            value[name.get(s[1])]--;
        }
        
        for(int i = 0; i < friends.length; i++) {
            int count = 0;
            for(int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                
                if(board[i][j] > board[j][i]) {
                    count++;
                }
                else if(board[i][j] == board[j][i] && value[i] > value[j]) {
                    count++;
                }
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
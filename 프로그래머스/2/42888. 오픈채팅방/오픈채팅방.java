import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList <String> answer = new ArrayList<>();
        HashMap <String, String> user = new HashMap<>();
        
        for(String rec : record) {
            String[] cmd = rec.split(" ");
            if(!cmd[0].equals("Leave"))
                user.put(cmd[1], cmd[2]);
        }
        
        for(String rec : record) {
            String[] cmd = rec.split(" ");
            
            if(cmd[0].equals("Enter"))
                answer.add(user.get(cmd[1]) + "님이 들어왔습니다.");
            else if(cmd[0].equals("Leave"))
                answer.add(user.get(cmd[1]) + "님이 나갔습니다.");
        }
        
        return answer.stream().toArray(String[]::new);
    }
    
    

}
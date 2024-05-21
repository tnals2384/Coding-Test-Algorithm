import java.util.*;
class Solution {
    HashSet<String> set;
    boolean[] visited;
    public int solution(String[] user_id, String[] banned_id) {
   
        for(int i=0;i<banned_id.length;i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        set = new HashSet<String>();
        visited = new boolean[user_id.length];
        
        dfs(0, banned_id, user_id, "");
        return set.size();
    }

    public void dfs(int idx, String[] banned_id, String[] user_id, String list) {
        if(idx == banned_id.length) {
            String[] A = list.split(" ");
            Arrays.sort(A);

            String str="";
            for(String id: A)
                str+=id;
            
            set.add(str);
            return;
        }

        for(int i=0;i <user_id.length; i++) {
            if(!visited[i] && user_id[i].matches(banned_id[idx])) {
                visited[i]= true;
                dfs(idx+1, banned_id, user_id, list+ " " + i);
                visited[i]= false;
            }
        }
    }
}
import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
     
        HashMap<String, Integer> map = new HashMap<>();
        for(String name: participant) {
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        
        for(String name: completion) {
            map.put(name, map.get(name)-1);
        }
        
        for(String s: map.keySet()) {
            if(map.get(s)==1) return s;
        }
        
        return null;
    }
}
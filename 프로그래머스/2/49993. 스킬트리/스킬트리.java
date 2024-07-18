import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
  
        for(String s : skill_trees) {
            //skill에 없는 글자는 다 공백으로 바꾸기
            String str = s.replaceAll("[^"+skill+"]", "");
            
            if(skill.startsWith(str)) answer++;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<String>();
        for(String gem: gems)
            set.add(gem);
        int size = set.size();
        
        
        HashMap<String, Integer> map = new HashMap<>();
        int start = 0;
        int len = gems.length;

        for(int i = 0;i<gems.length;i++) {
            map.put(gems[i], map.getOrDefault(gems[i],0)+1);
            
            //보석의 개수가 1개일때까지 start 인덱스를 앞으로 당김
            while(map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start])-1);
                start++;
            }
            
            //map에 모든 보석이 들어와있고, 구간이 최소라면 업데이트
            if(map.size() == size && len > i-start) {
                len = i-start;
                answer[0]= start+1;
                answer[1]= i+1;
            }
        }
        
        return answer;
    }
}
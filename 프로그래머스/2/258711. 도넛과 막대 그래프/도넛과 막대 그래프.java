import java.util.*;
class Solution {
    //추가된 노드는 들어오는 선이 없고, 나가는 선이 2개 이상임
    //도넛 모양은 나가는거 1개 들어오는거 1개
    //막대모양은 나가고 들어오는게 없을수도, 나가는게 1개 들어오는게 1개 일수도
    //8자 모양은 들어오는게 2개 나가는게 2개인게 중심 노드
    private static List<List<Integer>> graph;
    private static int[] enter;

    
    public int[] solution(int[][] edges) {
                
        int[] answer = new int[4];
        graph = new ArrayList<>();
        enter = new int[1000001];
     
        for(int i = 0; i <= 1000000; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            enter[edge[1]]++;
        }
        
        //find 추가된 노드
        answer[0] = find();
      
        int num = graph.get(answer[0]).size();
        
        answer[3] = findEight();
        answer[2] = findStick();
        answer[1] = num - answer[2] - answer[3];
        
        return answer;
    }
    
    //추가된 노드 찾기
    public int find() {
        for(int i = 1; i < graph.size(); i++) {
            if(graph.get(i).size() >= 2 && enter[i] == 0) 
                return i;
        }
        return -1;
    }
    
    //8자 개수 찾기
    public int findEight() {
        int count = 0;
        for(int i = 1; i < graph.size(); i++) {
            if(enter[i] >= 2 && graph.get(i).size() == 2) {
                count++;
            }
        }
        return count;
    }
    
    //막대 개수 찾기
    public int findStick() {
        int count = 0;
        for(int i = 1; i < graph.size(); i++) {
            if(enter[i] >= 1 && graph.get(i).size() == 0) count++;
        }
        
        return count;
    }
}
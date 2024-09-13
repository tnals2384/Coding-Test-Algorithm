import java.util.*;
class Solution {
    private static List<List<Integer>> graph;
    private static int[] enter;
    private static boolean[] visited;
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int max = 0;
        for(int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0],edge[1]));
        }
                              
        graph = new ArrayList<>(max+1);
        visited = new boolean[max+1];
        
        for(int i = 0; i < max + 1; i++) {
            graph.add(new LinkedList<>());
        }
        
        enter = new int[max + 1];
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            enter[edge[1]]++;
        }
        
        //나가는 간선이 2개 이상, 들어오는 간선 X
        int create = findCreate();

        //총 그래프 개수
        int totalGraphCount = graph.get(create).size();
 
        answer[0] = create;
        answer[2] = findStickGraph();
        answer[3] = findEightGraph();
        answer[1] = totalGraphCount - answer[2] - answer[3];
        return answer;
    }
    
    
    private static int findCreate() {
        for(int i = 0; i < graph.size(); i++) {
            if(graph.get(i).size() >= 2 && checkNotEnter(i)) {
                visited[i] = true;
                return i;
            }
        }
        return -1;
    }
    
    private static boolean checkNotEnter(int i) {
        if(enter[i] == 0) return true;
        else return false;
    }
    
    //나가는 간선 X, 들어오는 간선 >= 1
    private static int findStickGraph() {
        int count = 0;
        for(int i = 1; i < graph.size(); i++) {
            if(graph.get(i).isEmpty() && enter[i] >= 1 && !visited[i]) {
                visited[i] = true;
                count++;
            }
        }
        return count;
    }
    
    // 나가는 간선 >= 2 , 들어오는 간선 >= 2
    private static int findEightGraph() {
        int count = 0;
        for(int i = 1; i < graph.size(); i++) {
            if(graph.get(i).size() >= 2 && enter[i] >= 2 && !visited[i]) {
                count++;
            }
            visited[i] = true;
        }
        return count;
    }

}
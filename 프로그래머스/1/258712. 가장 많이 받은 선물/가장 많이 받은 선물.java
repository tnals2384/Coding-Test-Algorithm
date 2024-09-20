import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int N = friends.length;
        
        //인덱스 번호 매핑
        HashMap<String, Integer> index = new HashMap<>();
        
        int num=0;
        for(String f : friends) {
            index.put(f, num++);
        }
        
        //선물 지수와 선물 그래프 계산
        int[] score = new int[N];
        int[][] graph = new int[N][N];
        for(String g : gifts) {
            String[] friend = g.split(" ");
            score[index.get(friend[0])]++;
            score[index.get(friend[1])]--;
            graph[index.get(friend[0])][index.get(friend[1])]++;
        }
        
        //판단 시작
        for(int i=0; i<N; i++) {
            int count=0;
            for(int j=0; j<N; j++) {
                if(i==j) continue;
                
                //i가 더많이 줬을 경우
                if(graph[i][j] > graph[j][i]) {
                    count++;
                }
                
                //i의 선물지수가 더 높을 경우
                else if(graph[i][j]==graph[j][i]) {
                    if(score[i] > score[j])
                        count++;
                }
            }
            answer = Math.max(count, answer);
        }
        
        return answer;
    }
}
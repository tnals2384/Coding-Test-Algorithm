import java.util.*;

class Solution {
    int[] answer;
    int diceNum;
    int maxWin;
    int idx = 0;
    public int[] solution(int[][] dice) {
        
        diceNum = dice.length;
        boolean[] visited = new boolean[diceNum];
        
        //모든 경우의 수를 다 검사할 필요 없음
        //첫번째 주사위를 고른다 생각하고 고르고, 골라지지 않은게 다른 경우의 수를 맡음
        visited[0] = true;
        answer = new int[diceNum / 2];
        maxWin = -1;
        comb(1, 1, visited, dice);
        
        return answer;
    }
    
    //주사위 고르기
    public void comb(int idx, int count, boolean[] visited, int[][] dice) {
        if(count == diceNum / 2) {
            // 합 계산하기
            int[] A = getScoreSum(true, visited, dice);
            int[] B = getScoreSum(false, visited, dice);
            
            Arrays.sort(A);
            Arrays.sort(B);
            
            int Awin = getWinCount(A, B);
            int Bwin = getWinCount(B, A);
            
            int max = Math.max(maxWin, Math.max(Awin, Bwin));
            
            int answerIdx = 0;
            if(max == Awin) {
                //visited true인걸로 정답배열 업데이트
                for(int i=0; i < diceNum; i++) {
                    if(visited[i]) answer[answerIdx++] = i+1;
                }
            }
            else if(max == Bwin) {
                for(int i=0; i < diceNum; i++) {
                    if(!visited[i]) answer[answerIdx++] = i+1;
                }
            }
            
            maxWin = max;
            return;
        }
        
        for(int i = idx; i < diceNum; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            comb(i + 1, count + 1, visited, dice);
            visited[i] = false;
        }
    }
    
    public int[] getScoreSum(boolean isTrue, boolean[] visited, int[][] dice) {
        int[] sumArray = new int[(int) Math.pow(6, diceNum/2)];
        int[] selectDice = new int[diceNum/2];
        int index = 0;
        
        for(int i = 0; i < diceNum; i++) {
            if(visited[i] == isTrue) {
                selectDice[index++] = i;
            }
        }
        idx = 0;
        perm(selectDice, sumArray, 0, 0, dice);
        //선택된 주사위의 가능한 모든 합을 저장한 배열을 return
        return sumArray;
    }
    
    public void perm(int[] selectDice, int[] sumArray, int depth, int sum, int[][] dice) {
        if(depth == diceNum / 2) {
            sumArray[idx++] = sum;
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            perm(selectDice, sumArray, depth + 1, sum + dice[selectDice[depth]][i], dice);

        }
    }
    
    public int getWinCount(int[] A, int[] B) {
        int s = 0;
        int e = B.length-1;
        int win = 0;
        for(int a: A) {
            e = B.length-1;
            while(s <= e) {
                int mid = (s+e) / 2;
                if(a > B[mid]) {
                    s = mid + 1;
                }
                else {
                    e = mid - 1;
                }
            }
            win += s-1;
        }
        
        return win;
    }
}
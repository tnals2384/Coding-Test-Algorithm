import java.util.*;

class Solution {
    public static class Point {
        boolean p; // 기둥
        boolean b; // 보

        public Point(boolean p, boolean b) {
            this.p = p;
            this.b = b;
        }
    }

    Point[][] board;

    public int[][] solution(int n, int[][] build_frame) {
        board = new Point[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                board[i][j] = new Point(false, false);
            }
        }

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2]; // 기둥 0, 보 1
            int b = frame[3]; // 삭제 0, 설치 1

            if (a == 0 && b == 0) { // 기둥 삭제
                board[y][x].p = false;
                if (!canDelete(n)) {
                    board[y][x].p = true;
                }
            } else if (a == 1 && b == 0) { // 보 삭제
                board[y][x].b = false;
                if (!canDelete(n)) {
                    board[y][x].b = true;
                }
            } else if (a == 0 && b == 1) { // 기둥 설치
                if (checkP(x, y)) {
                    board[y][x].p = true;
                }
            } else { // 보 설치
                if (checkB(x, y)) {
                    board[y][x].b = true;
                }
            }
        }

        List<int[]> answerList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[j][i].p) {
                    answerList.add(new int[]{i, j, 0});
                }
                if (board[j][i].b) {
                    answerList.add(new int[]{i, j, 1});
                }
            }
        }

        int[][] answer = new int[answerList.size()][3];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public boolean checkP(int x, int y) {
        if (y == 0) return true;
        if (y > 0 && board[y - 1][x].p) return true;
        if (x > 0 && board[y][x - 1].b) return true;
        if (board[y][x].b) return true;
        return false;
    }

    public boolean checkB(int x, int y) {
        if (y > 0 && (board[y - 1][x].p || (x < board.length - 1 && board[y - 1][x + 1].p))) return true;
        if (x > 0 && x < board.length - 1 && board[y][x - 1].b && board[y][x + 1].b) return true;
        return false;
    }

    public boolean canDelete(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (board[i][j].p && !checkP(j, i)) return false;
                if (board[i][j].b && !checkB(j, i)) return false;
            }
        }
        return true;
    }
}
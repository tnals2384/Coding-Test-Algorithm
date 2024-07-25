import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int winCount;
    static int loseCount;
    static ArrayList<Integer> gu;
    static ArrayList<Integer> in;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            gu = new ArrayList<>();
            in = new ArrayList<>();
			winCount=0;
            loseCount=0;
            visited = new boolean[9];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                gu.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= 18; i++) {
                if (!gu.contains(i))
                    in.add(i);
            }

            perm(0, 0, 0);

            System.out.println("#" + test_case+ " " + winCount + " " + loseCount);

        }
    }

    public static void perm(int depth, int guSum, int inSum) {
        if (depth == 9) {
            if (guSum > inSum) winCount++;
            else if (guSum < inSum) loseCount++;
        }

        for (int i = 0; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int sum = gu.get(depth) + in.get(i);
                if (gu.get(depth) > in.get(i))
                    perm(depth + 1, guSum + sum, inSum);
                else perm(depth + 1, guSum, inSum + sum);
                visited[i] = false;
            }
        }
    }
}
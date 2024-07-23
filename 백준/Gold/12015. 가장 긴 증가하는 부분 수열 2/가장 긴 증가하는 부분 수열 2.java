import java.util.Scanner;

public class Main {

    //LIS 알고리즘 2가지
    //1. 일반적인 dp O(n^2)
    //반복문 2번 돌려서 dp 값 업데이트
    //2. 이진탐색을 이용한 dp O(nlogn)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();

        int[] dp = new int[N];
        dp[0] = A[0];
        //증가하는 부분 수열 중 끝점의 최솟값을 구함
        int dpLen = 1;
        for (int i = 1; i < N; i++) {
            if (dp[dpLen - 1] < A[i])
                dp[dpLen++] = A[i];
            else {
                int idx = binarySearch(dp, 0, dpLen - 1, A[i]);
                dp[idx] = A[i];
            }
        }
        System.out.println(dpLen);
    }

    //lowerBound 구함. k의 시작 위치를 찾음
    public static int binarySearch(int[] dp, int s, int e, int k) {
        while (s < e) {
            int mid = (s + e) / 2;

            if (dp[mid] < k)
                s = mid + 1;
            else e = mid;
        }
        return e;
    }


}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

        //1. 소수 구하기
        int[] A = new int[10000001]; //최대 범위에 해당하는 모든 소수

        for(int i=2;i<A.length;i++)
            A[i]=i;

        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0)
                continue;

            for (int j = i + i; j < A.length; j += i)
                A[j] = 0;
        }

        //2. N보다 크거나 같은 수중 팰린드롬 중 가장 작은 수 구하기
        for (int i = N; i < A.length; i++) {
            if(A[i]!= 0) {
                String number = String.valueOf(A[i]);

                int s = 0;
                int e = number.length() - 1;
                boolean isPalindrome = true;
                while (s < e) {
                    if (number.charAt(s) != number.charAt(e))
                        isPalindrome = false;
                    s++;
                    e--;
                }

                if (isPalindrome) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    static int[][] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        tree = new int[26][2];
        for (int i = 0; i < N; i++) {
            char root = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            
            if (left == '.')
                tree[root - 'A'][0] = -1;
            else tree[root - 'A'][0] = left - 'A';

            if (right == '.')
                tree[root - 'A'][1] = -1;
            else tree[root - 'A'][1] = right - 'A';

        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    public static void preOrder(int n) {
        if (n == -1) return;

        System.out.print((char) (n + 'A')); //루트 먼저출력 
        preOrder(tree[n][0]); //왼쪽노드 탐색 
        preOrder(tree[n][1]); //오른쪽 노드 탐색

    }

    public static void inOrder(int n) {
        if (n == -1) return;
        inOrder(tree[n][0]); //왼쪽노드 탐색
        System.out.print((char) (n + 'A')); //루트 출력
        inOrder(tree[n][1]); //오른쪽노드 탐색

    }

    public static void postOrder(int n) {
        if (n == -1) return;
        postOrder(tree[n][0]); //왼쪽노드 탐색 
        postOrder(tree[n][1]); //오른쪽노드 탐색
        System.out.print((char) (n + 'A')); //루트 출력

    }
}

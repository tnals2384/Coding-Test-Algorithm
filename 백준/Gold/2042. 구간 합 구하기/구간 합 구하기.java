import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int k = 0;
        while(true) {
            if(Math.pow(2,k) < N)
                k++;
            else break;
        }

        int treeSize = (int) (Math.pow(2,k+1));
        int start = (treeSize/2);

        tree = new long[treeSize];

        for(int i=start;i<start + N;i++)
            tree[i] = Long.parseLong(br.readLine());

        //구간합 트리 초기화
        setTree(treeSize-1);

        for(int i=0;i<M+K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            //수를 바꾸고, 구간합 트리 업데이트
            if(a==1) {
                change(start-1+b, c);
            }
            //구간합 구하기
            else {
                System.out.println(partSum(start-1+b, (int) (start-1+c)));
            }
        }
    }
    public static void setTree(int idx) {
        while(idx != 1) {
            tree[idx/2] += tree[idx];
            idx--;
        }
    }

    public static void change(int b, long c) {
        long diff = c - tree[b];
        int idx = b;
        while(idx > 0) {
            tree[idx] += diff;
            idx/=2;
        }
    }

    public static long partSum(int b, int c) {
        long sum = 0;
        while(b <= c) {

            if( b % 2 == 1) {
                sum+= tree[b];
            }

            if( c % 2 == 0) {
                sum+= tree[c];
            }
            b = (b+1)/2;
            c = (c-1)/2;
        }
        return sum;
    }
}

import java.util.Scanner;

public class Solution {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int T= sc.nextInt();

        for(int test_case = 1; test_case<=T;test_case++) {
            int n =sc.nextInt();
            int m =sc.nextInt();

            arr = new int[n+1];
            for(int i=0;i<n;i++)
                arr[i]=i;

            StringBuilder str = new StringBuilder();
            for(int i=0;i<m;i++) {
                int c = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(c==0) {
                    if(find(a) != find(b))
                        union(a,b);
                }
                if(c==1) {
                    if(find(a)==find(b))
                        str.append("1");
                    else
                        str.append("0");
                }
            }

            System.out.println("#"+test_case+ " "+ str);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            arr[b] = a;
    }

    public static int find(int a ) {
        if(arr[a]== a)
            return a;
        else
            return arr[a] = find(arr[a]);
    }
}

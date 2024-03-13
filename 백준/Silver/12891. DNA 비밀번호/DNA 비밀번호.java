import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int myArr[];
    static int checkA[];
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result =0;

        char A[] = new char[S];
        myArr = new int[4];
        checkA = new int[4];
        count = 0;
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkA[i] = Integer.parseInt(st.nextToken());
            if (checkA[i] == 0) count++;
        }

        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if(count==4)
            result++;

        for(int i=P;i<S;i++) {
            int j= i-P;
            Add(A[i]);
            Remove(A[j]);
            if(count==4)
                result++;
        }
        System.out.println(result);
    }

        private static void Add(char c){
            switch (c) {
                case 'A':
                    myArr[0]++;
                    if(myArr[0]==checkA[0])
                        count++;
                    break;
                case 'C':
                    myArr[1]++;
                    if(myArr[1]==checkA[1])
                        count++;
                    break;
                case 'G':
                    myArr[2]++;
                    if(myArr[2]==checkA[2])
                        count++;
                    break;
                case 'T':
                    myArr[3]++;
                    if(myArr[3]==checkA[3])
                        count++;
                    break;
            }
        }

        private static void Remove(char c) {
            switch(c) {
                case 'A':
                    if(myArr[0]==checkA[0])
                        count--;
                    myArr[0]--;
                    break;
                case 'C':
                    if(myArr[1]==checkA[1])
                        count--;
                    myArr[1]--;
                    break;
                case 'G':
                    if(myArr[2]==checkA[2])
                        count--;
                    myArr[2]--;
                    break;
                case 'T':
                    if(myArr[3]==checkA[3])
                        count--;
                    myArr[3]--;
                    break;
            }
        }
    }

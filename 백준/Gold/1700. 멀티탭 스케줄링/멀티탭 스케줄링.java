import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> name =new ArrayList<>();
        boolean[] use = new boolean[K+1];
        int count=0;
        int put=0;
        for(int i=0;i<K;i++) {
            name.add(sc.nextInt());
        }

        for(int i=0;i<K;i++) {
            int order = name.get(i);

            if (!use[order]) {//콘센트가 꽂혀있지 않음
                if (put < N) {
                    use[order] = true;
                    put++;
                } else { //코드를 뽑아야 하는 경우
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int j = i; j < K; j++) {
                        if (use[name.get(j)] && !list.contains(name.get(j))) {
                            list.add(name.get(j));
                        }
                    }

                    if (list.size() != N) {
                        for (int j = 0; j < K; j++) {
                            if (use[j] && !list.contains(j)) {
                                use[j] = false;
                                break;
                            }
                        }
                    } else {
                        int remove = list.get(list.size() - 1);
                        use[remove] = false;
                    }

                    use[order] = true;
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
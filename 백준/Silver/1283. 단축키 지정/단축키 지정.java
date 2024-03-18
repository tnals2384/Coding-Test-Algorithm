import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean case1(String[] data, Set<String> set) throws IOException{
        for(int i = 0; i < data.length; i++ ){
            String s = data[i];
            String t = s.substring(0, 1);
            if(!set.contains(t.toLowerCase())){
                set.add(t.toLowerCase());
                for(int j = 0; j < data.length; j++){
                    if(j == i){
                        bw.write("[" + t + "]" + s.substring(1) +" ");
                    }else{
                        bw.write(data[j] + " ");
                    }
                }

                bw.write("\n");
                return true;
            }
        }

        return false;
    }

    public static boolean case2(String origin, String[] data, Set<String> set) throws IOException{
        for(int i = 0; i < data.length; i++){
            String s = data[i];

            if(s.equals(" ")){
                continue;
            }

            if(!set.contains(s.toLowerCase())){
                set.add(s.toLowerCase());
                bw.write(origin.substring(0,i) + "[" + s + "]" + origin.substring(i+1) + "\n");
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        int t = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0; i < t; i++){
            String input = br.readLine();
            String[] data1 = input.split(" ");
            String[] data2 = input.split("");
            if(case1(data1, set)){}
            else if(case2(input, data2, set)){}
            else {
                bw.write(input + "\n");
            }
        }

        bw.flush();
    }
}
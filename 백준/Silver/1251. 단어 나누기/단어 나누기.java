import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String[] str = new String[3];

        for(int i=1;i< word.length()-1;i++) {
            for(int j=i+1;j<word.length();j++) {
                str[0]= word.substring(0,i);
                str[1]= word.substring(i,j);
                str[2]=word.substring(j);
                for(int k=0;k<3;k++) {
                    StringBuffer sb =new StringBuffer(str[k]);
                    str[k]=sb.reverse().toString();
                }
                String new_word = str[0]+str[1]+str[2];
                words.add(new_word);
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
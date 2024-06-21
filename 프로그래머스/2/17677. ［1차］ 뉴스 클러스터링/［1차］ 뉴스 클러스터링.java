import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
      
        for(int i = 0 ; i < str1.length() - 1 ; i++){
            char first = str1.charAt(i);
             char second = str1.charAt(i + 1);
          
             if(first >= 'a' && first <= 'z' &&
                second >= 'a' && second <= 'z'){
                  A.add(first + "" + second);
              }
        }
      
        for(int i = 0 ; i < str2.length() - 1 ; i++){
           char first = str2.charAt(i);
           char second = str2.charAt(i + 1);
          
           if(first >= 'a' && first <= 'z' &&
              second >= 'a' && second <= 'z'){
               B.add(first + "" + second);
             }
         }
        
        int two = 0;
        int one = 0;
        for(String a: A) {
            if(B.remove(a)) {
                two++;
            }
            one++;
        }
        
        one += B.size();
        
        if(one==0) answer = 1;
        else answer = (double) two / (double) one;
        
        return (int) (answer * 65536);
        
        
        

    }
}
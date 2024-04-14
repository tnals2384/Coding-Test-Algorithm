import java.util.*;
class Solution {
    static char[] alphabet = {'A','E','I','O','U'}; 
    static ArrayList<String> dict;
    public int solution(String word) {
        int answer = 0;
    

        dict = new ArrayList<>();
        dfs("", 0);
        
        Collections.sort(dict);
        return dict.indexOf(word)+1;
    }
    
    public static void dfs(String word, int depth) {
        if(depth==5)
            return;
        
        for(int i=0;i < alphabet.length;i++) {
                dict.add(word+alphabet[i]);
                dfs(word+alphabet[i], depth+1);
                
            }
        }
    }

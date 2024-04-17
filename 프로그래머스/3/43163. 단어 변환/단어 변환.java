import java.util.*;

class Solution {
    public class Word {
        String word;
        int count;
        
        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target))
            return 0;
        
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin,0));
        
        while(!queue.isEmpty()) {
            Word now = queue.poll();
            
            if(now.word.equals(target))
                return now.count;
            
            for(String word: words) {
                int count = 0;
                for(int i=0;i< word.length();i++) {
                    if(now.word.charAt(i) != word.charAt(i))
                        count++;
                }
                if(count == 1)
                    queue.add(new Word(word,now.count+1));
            }
            
        }
        return 0;
    }
}
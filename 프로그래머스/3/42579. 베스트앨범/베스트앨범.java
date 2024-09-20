import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, Map<Integer, Integer>> genre = new HashMap<>();
        
        for(int i=0;i<genres.length;i++) {
            if(!total.containsKey(genres[i])) {
                total.put(genres[i], plays[i]);
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genre.put(genres[i],map);
            }
            else {
                total.put(genres[i], total.get(genres[i])+plays[i]);
                genre.get(genres[i]).put(i,plays[i]);
            }
        }
        
        ArrayList<String> keys = new ArrayList<>(total.keySet());
        keys.sort(Comparator.comparingInt(i -> total.get(i)).reversed());
        
        for(String key : keys) {
            ArrayList<Integer> genreKeys = new ArrayList<>(genre.get(key).keySet());
            genreKeys.sort(Comparator.comparingInt(i -> genre.get(key).get(i)).reversed());
            
            for(int i=0;i<2;i++) {
                if(genreKeys.size() > i)
                    answer.add(genreKeys.get(i));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
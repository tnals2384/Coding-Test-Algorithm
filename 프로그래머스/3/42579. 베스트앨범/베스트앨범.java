import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> inGenre = new HashMap<>();

        for(int i=0;i < genres.length;i++) {
            if(!total.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                inGenre.put(genres[i], map);
                total.put(genres[i], plays[i]);
            } else {
                inGenre.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], total.get(genres[i]) + plays[i]);
            }
        }

        List<String> keySet = new ArrayList<>(total.keySet());
        keySet.sort((o1, o2) -> total.get(o2) - total.get(o1));

        for(String key : keySet) {
            HashMap<Integer,Integer> map = inGenre.get(key);
            List<Integer> genreKeys = new ArrayList<>(map.keySet());
            genreKeys.sort((o1, o2) -> map.get(o2) - map.get(o1));
 
            answer.add(genreKeys.get(0));
            if(genreKeys.size() > 1)
                answer.add(genreKeys.get(1));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
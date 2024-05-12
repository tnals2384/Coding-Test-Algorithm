import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> total = new HashMap<>();
        HashMap<String,HashMap<Integer,Integer>> genre = new HashMap<>();

        for(int i = 0;i < genres.length; i++) {
            if(!total.containsKey(genres[i])) {
                total.put(genres[i], plays[i]);
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                genre.put(genres[i], map);
            }
            else {
                total.put(genres[i],total.get(genres[i])+plays[i]);
                genre.get(genres[i]).put(i,plays[i]);
            }
        }

        ArrayList<String> keys = new ArrayList<>(total.keySet());
        keys.sort(Comparator.comparingInt(total::get).reversed());

        for(String key : keys) {
            ArrayList<Integer> indexs = new ArrayList<>(genre.get(key).keySet());
            indexs.sort(Comparator.comparingInt(genre.get(key)::get).reversed());
            for(int i=0;i<2;i++) {
                answer.add(indexs.get(i));
                if(indexs.size() < 2)
                    break;
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
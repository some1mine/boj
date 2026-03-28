import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        cities = Arrays.stream(cities).map(String::toLowerCase).toArray(String[]::new);
        for(String city : cities) {
            if(!cache.contains(city)) {
                answer += 5; cache.add(city); count.add(cacheSize);
            } else {
                answer += 1; int idx = cache.indexOf(city); count.set(idx, cacheSize);
            }
            int minIdx = 0;
            for(int i = 0 ; i < cache.size() ; i++) {
                count.set(i, count.get(i) - 1);
                if(count.get(minIdx) > count.get(i)) minIdx = i;
            }
            if(cache.size() > cacheSize) {
                cache.remove(minIdx);
                count.remove(minIdx);   
            }
        }
        return answer;
    }
}
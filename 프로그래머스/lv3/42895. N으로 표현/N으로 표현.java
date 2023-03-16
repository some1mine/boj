import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1 ; i <= 8 ; i++) {
            String num = "";
            for(int j = 0 ; j < i ; j++) num += N;
            map.put(Integer.parseInt(num), i);
        }
        for(Integer key : map.keySet()) {
            if(key == number) return map.get(key);
        }
        
        for(int i = 0 ; i < 8 ; i++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for(Integer key1 : map.keySet()) {
                for(Integer key2 : map.keySet()) {
                    int cnt = map.get(key1) + map.get(key2);
                    int addVal = key1 + key2;
                    int subVal = key1 - key2;
                    int multiVal = key1 * key2;
                    int divideVal = key2 != 0 ? key1 / key2 : 0;
                    if(cnt <= 8) {
                        if(cnt < tmp.getOrDefault(addVal, 10)) tmp.put(addVal, cnt);
                        if(cnt < tmp.getOrDefault(subVal, 10)) tmp.put(subVal, cnt);
                        if(cnt < tmp.getOrDefault(multiVal, 10)) tmp.put(multiVal, cnt);
                        if(key2 != 0 && cnt < tmp.getOrDefault(divideVal, 10)) tmp.put(divideVal, cnt);
                    }
                }
            }
            map.putAll(tmp);
            if(map.containsKey(number)) return map.get(number) > 8 ? - 1 : map.get(number);
        }
        return answer;
    }
}
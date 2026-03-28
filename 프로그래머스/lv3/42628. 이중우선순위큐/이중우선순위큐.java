import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(String s : operations) {
            String[] tmp = s.split(" ");
            if(tmp[0].equals("I")) {
                int n = Integer.parseInt(tmp[1]);
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            else if(!map.isEmpty() && tmp[1].equals("1")) {
                if(map.get(map.lastKey()) == 1) map.remove(map.lastKey());
                else map.put(map.lastKey(), map.get(map.lastKey()) - 1);
            } else if(!map.isEmpty() && tmp[1].equals("-1")) {
                if(map.get(map.firstKey()) == 1) map.remove(map.firstKey());
                else map.put(map.firstKey(), map.get(map.firstKey()) - 1);
            }
        }
        if(!map.isEmpty()) return new int[]{map.lastKey(), map.firstKey()};
        return answer;
    }
}
import java.util.*;

class Solution {
    public Map<String, Integer> map = new HashMap<>();
    public int[] solution(String msg) {
        int index = 0;
        for(char c = 'A' ; c <= 'Z' ; c++) map.put(Character.toString(c), ++index);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < msg.length() ; i++) {
            for(int j = msg.length() - i ; j > 0 ; j--) {
                String tmp = msg.substring(i, i + j);
                if(map.containsKey(tmp)) {
                    list.add(map.get(tmp)); 
                    if(i + j < msg.length()) map.put(tmp + msg.charAt(i + j), ++index);
                    i += tmp.length() - 1; break;
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
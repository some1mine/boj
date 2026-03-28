import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        report = set.toArray(new String[0]);
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String r : report) {
            String victim = r.split(" ")[1];
            if(!map.containsKey(victim)) map.put(victim, 1);
            else map.put(victim, map.get(victim) + 1);
        }
        
        for(int i = 0 ; i < id_list.length ; i++) {
            for(String r : report) {
                String avanger = r.split(" ")[0];
                String victim = r.split(" ")[1];
                if(map.get(victim) >= k && id_list[i].equals(avanger)) answer[i]++;
            }
        }
        return answer;
    }
}
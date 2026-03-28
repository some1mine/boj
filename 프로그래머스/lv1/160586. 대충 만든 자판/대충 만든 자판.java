import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        List<List<String>> list = new ArrayList<>();
        for(int i = 0 ; i < keymap.length ; i++) {
            list.add(new ArrayList<>());
            for(String s : keymap[i].split("")) list.get(i).add(s);
        }
        for(int i = 0 ; i < targets.length ; i++) {
            int ans = 0;
            for(String s : targets[i].split("")) {
                int tmp = Integer.MAX_VALUE;
                for(List<String> lst : list) {
                    if(lst.indexOf(s) != -1) tmp = Math.min(tmp, lst.indexOf(s) + 1);
                } 
                if(tmp == Integer.MAX_VALUE) {
                    ans = -1; break;
                }
                ans += tmp;
            }
            answer[i] = ans;
        }
        return answer;
    }
}
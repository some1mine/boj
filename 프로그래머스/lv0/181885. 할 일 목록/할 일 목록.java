import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        String[] answer;
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < finished.length ; i++) {
            if(!finished[i]) list.add(todo_list[i]);
        }
        answer = list.stream().toArray(String[]::new);
        return answer;
    }
}
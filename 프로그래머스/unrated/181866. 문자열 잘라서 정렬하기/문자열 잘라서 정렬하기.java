import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        String str = "";
        for(char c : myString.toCharArray()) {
            if(c == 'x') {
                list.add(str);
                str = "";
            } else {
                str += c;
            }
        }
        if(str != "") list.add(str);
        answer = list.stream().filter(x -> !x.equals("")).sorted().toArray(String[]::new);
        return answer;
    }
}
import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        String str = "";
        for(int i = 0 ; i < myStr.length() ; i++) {
            char c = myStr.charAt(i);
            if(c == 'a' || c == 'b' || c == 'c') {
                if(!str.isEmpty()) list.add(str); str = "";
            } else {
                str += c;
            }
        }
        if(!str.isEmpty()) list.add(str);
        if(list.isEmpty()) return new String[]{"EMPTY"};
        return list.stream().toArray(String[]::new);
    }
}
import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public int solution(String word) {
        recursive("");
        return list.indexOf(word);
    }
    public void recursive(String str) {
        list.add(str);
        if(str.length() == 5) return;
        for(int i = 0 ; i < 5 ; i++) recursive(str + "AEIOU".charAt(i));
    }
}
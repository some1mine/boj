import java.util.*;

class Solution {
    public List<String> list = new ArrayList<>();
    public int solution(String word) {
        initialize("");
        return list.indexOf(word);
    }
    public void initialize(String word) {
        list.add(word);
        if(word.length() == 5) return;
        for(int i = 0 ; i < 5 ; i++) initialize(word + "AEIOU".charAt(i));
    }
}
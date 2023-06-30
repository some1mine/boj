import java.util.*;

class Solution {
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        generate("", list);
        return list.indexOf(word);
    }
    public void generate(String word, List<String> list) {
        list.add(word);
        if(word.length() == 5) return;
        for(int i = 0 ; i < 5 ; i++) generate(word + "AEIOU".charAt(i), list);
    }
}
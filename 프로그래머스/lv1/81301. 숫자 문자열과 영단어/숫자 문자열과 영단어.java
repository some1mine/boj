import java.util.*;

class Solution {
    public String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public int solution(String s) {
        int answer = 0;
        for(int i = 0 ; i < words.length ; i++) s = s.replace(words[i], Integer.toString(i));
        answer = Integer.parseInt(s);
        return answer;
    }
}
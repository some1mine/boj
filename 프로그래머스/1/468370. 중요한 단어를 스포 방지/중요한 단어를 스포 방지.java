import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0; boolean[] isSpoiler = new boolean[message.length()];
        List<int[]> words = new ArrayList<>(); Set<String> others = new HashSet<>();
        for (int[] spoiler : spoiler_ranges) IntStream.range(spoiler[0], spoiler[1] + 1).forEach(i -> isSpoiler[i] = true);

        for(int i = 0 ; i < message.length() ; i++) {
            if(message.charAt(i) == ' ') continue;
            int start = i;
            while(i < message.length() && message.charAt(i) != ' ') i++;
            words.add(new int[]{start, --i});
        }

        for (int[] w : words) {
            boolean contains = IntStream.range(w[0], w[1] + 1).anyMatch(i -> isSpoiler[i]);
            if (!contains) others.add(message.substring(w[0], w[1] + 1));
        }

        for (int[] spoiler : spoiler_ranges) {
            for(int i = spoiler[0] ; i <= spoiler[1] ; i++) {
                while(message.charAt(i) == ' ') i++;
                int start = i;
                while(start > 0 && message.charAt(start - 1) != ' ') start--;
                while(i < message.length() - 1 && message.charAt(i + 1) != ' ') i++;
                String word = message.substring(start, i + 1);
                if(!others.contains(word)) {
                    answer++; others.add(word);
                }
            }
        }
        return answer;
    }
}
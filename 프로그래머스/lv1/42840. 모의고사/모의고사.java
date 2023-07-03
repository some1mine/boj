import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] ways = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] count = new int[3];
        int max = -1;
        for(int i = 0 ; i < answers.length ; i++) {
            for(int j = 0 ; j < ways.length ; j++) {
                if(answers[i] == ways[j][i % ways[j].length]) count[j]++;
                max = Math.max(max, count[j]);
            }
        }
        final int maxNum = max;
        return IntStream.range(0, 3).filter(i -> count[i] == maxNum).map(i -> i + 1).toArray();
    }
}
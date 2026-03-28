import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0, ord = 0, idx = 0;
        int[][] tireded = new int[minerals.length / 5 + 1][3];
        for(int i = 0 ; i < minerals.length && i < IntStream.of(picks).sum() * 5; i++) {
            if(minerals[i].equals("diamond")) {
                tireded[i / 5][0] += 1; tireded[i / 5][1] += 5; tireded[i / 5][2] += 25;
            } else if(minerals[i].equals("iron")) {
                tireded[i / 5][0] += 1; tireded[i / 5][1] += 1; tireded[i / 5][2] += 5;
            } else {
                tireded[i / 5][0] += 1; tireded[i / 5][1] += 1; tireded[i / 5][2] += 1;
            }
        }
        Arrays.sort(tireded, (a, b) -> b[2] - a[2]);
        System.out.println(Arrays.deepToString(tireded));
        while(idx < tireded.length) {
            while(ord < 3 && picks[ord] == 0) ord++;
            if(ord == 3) break;
            answer += tireded[idx++][ord];
            picks[ord]--;
        }
        return answer;
    }
}
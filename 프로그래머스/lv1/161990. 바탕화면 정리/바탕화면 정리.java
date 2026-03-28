import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = Integer.MAX_VALUE; answer[1] = Integer.MAX_VALUE;
        answer[2] = Integer.MIN_VALUE; answer[3] = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < wallpaper.length ; i++) {
            if(wallpaper[i].contains("#")) {
                if(answer[0] > i) answer[0] = i;
                if(answer[2] <= i) answer[2] = i + 1;
                if(answer[1] > wallpaper[i].indexOf("#")) answer[1] = wallpaper[i].indexOf("#");
                if(answer[3] <= wallpaper[i].lastIndexOf("#")) answer[3] = wallpaper[i].lastIndexOf("#") + 1;
            }
        }
        return answer;
    }
}
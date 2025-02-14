import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0 ; i < schedules.length ; i++) {
            schedules[i] += schedules[i] % 100 >= 50 ? 50 : 10;
            schedules[i] =  schedules[i] / 100 *  60  + schedules[i] % 100;
        } 
        for(int i = 0 ; i < timelogs.length ; i++) {
            for(int j = 0 ; j < timelogs[i].length ; j++) 
                timelogs[i][j] = timelogs[i][j] / 100 * 60 + timelogs[i][j] % 100;
        }
        
        for(int i = 0 ; i < schedules.length ; i++) {
            boolean isReceiver = true;
            for(int j = 0 ; j < 7 ; j++) {
                if((j + startday) % 7 == 6 || j + startday == 7) continue;
                if(schedules[i] < timelogs[i][j]) {
                    isReceiver = false; break;
                }
            }
            answer += isReceiver ? 1 : 0;
        }
        return answer;
    }
}
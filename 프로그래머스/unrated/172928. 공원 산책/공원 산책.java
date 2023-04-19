import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        for(int i = 0 ; i < park.length ; i++) {
            if(park[i].contains("S")) {
                answer[0] = i; answer[1] = park[i].indexOf("S"); break;
            }
        }
        outLoop:
        for(String s : routes) {
            String[] arr = s.split("\\s");
            switch(arr[0]) {
                case "N":
                    if(answer[0] - Integer.parseInt(arr[1]) < 0) continue outLoop;
                    for(int i = answer[0] - Integer.parseInt(arr[1]) ; i <= answer[0] ; i++) {
                        if(park[i].charAt(answer[1]) == 'X') continue outLoop;
                    }
                    answer[0] -= Integer.parseInt(arr[1]);
                    break;
                case "S":
                    if(answer[0] + Integer.parseInt(arr[1]) >= park.length) continue outLoop;
                    for(int i = answer[0] + Integer.parseInt(arr[1]) ; i >= answer[0] ; i--) {
                        if(park[i].charAt(answer[1]) == 'X') continue outLoop;
                    }
                    answer[0] += Integer.parseInt(arr[1]);
                    break;
                case "W":
                    if(answer[1] - Integer.parseInt(arr[1]) < 0) continue outLoop;
                    for(int i = answer[1] - Integer.parseInt(arr[1]) ; i <= answer[1] ; i++) {
                        if(park[answer[0]].charAt(i) == 'X') continue outLoop;
                    }
                    answer[1] -= Integer.parseInt(arr[1]);
                    break;
                case "E":
                    if(answer[1] + Integer.parseInt(arr[1]) >= park[0].length()) continue outLoop;
                    for(int i = answer[1] + Integer.parseInt(arr[1]) ; i >= answer[1] ; i--) {
                        if(park[answer[0]].charAt(i) == 'X') continue outLoop;
                    }
                    answer[1] += Integer.parseInt(arr[1]);
                    break;
            }
        }
        return answer;
    }
}
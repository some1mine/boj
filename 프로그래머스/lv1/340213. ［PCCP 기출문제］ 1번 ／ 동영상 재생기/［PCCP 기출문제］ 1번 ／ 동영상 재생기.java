import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] length = Arrays.stream(video_len.split(":")).mapToInt(Integer::parseInt).toArray(),
              startPos = Arrays.stream(pos.split(":")).mapToInt(Integer::parseInt).toArray(),
              openStart = Arrays.stream(op_start.split(":")).mapToInt(Integer::parseInt).toArray(),
              openEnd = Arrays.stream(op_end.split(":")).mapToInt(Integer::parseInt).toArray();

        for(String command : commands) {
            if(startPos[0] * 60 + startPos[1] >= openStart[0] * 60 + openStart[1]
              && startPos[0] * 60 + startPos[1] <= openEnd[0] * 60 + openEnd[1]) {
                startPos[0] = openEnd[0]; startPos[1] = openEnd[1];
            }
            if(command.equals("prev")) {
                int second = startPos[1] - 10;
                if(second < 0) {
                    if(startPos[0] == 0) startPos[1] = 0;
                    else {
                        startPos[0]--; startPos[1] = startPos[1] + 50;
                    }
                } else startPos[1] = second;
            } else if(command.equals("next")) {
                int second = startPos[1] + 10;
                if(second > 59) {
                    if(startPos[0] == length[0]) startPos[1] = second;
                    else {
                        startPos[0]++; startPos[1] = startPos[1] - 50;
                    }
                } else startPos[1] = second;
                if(startPos[0] == length[0]) startPos[1] = Math.min(startPos[1], length[1]);
            }
            if(startPos[0] * 60 + startPos[1] >= openStart[0] * 60 + openStart[1]
              && startPos[0] * 60 + startPos[1] <= openEnd[0] * 60 + openEnd[1]) {
                startPos[0] = openEnd[0]; startPos[1] = openEnd[1];
            }
        }

        return String.format("%02d", startPos[0]) + ":" + String.format("%02d", startPos[1]);
    }
}
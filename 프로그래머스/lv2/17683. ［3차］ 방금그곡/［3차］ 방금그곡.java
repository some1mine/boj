import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)"; int max = 0;
        m = m.replaceAll("C#", "H").replaceAll("D#", "I")
            .replaceAll("F#", "J").replaceAll("G#", "K").replaceAll("A#", "L").replaceAll("B#", "M");
        for(String musicInfo : musicinfos) {
            String[] music = musicInfo.split(",");
            int playTime = getTime(music[0], music[1]);
            if(playTime > max && matches(m, music, playTime)) {
                answer = music[2]; max = playTime;
            }
        }
        return answer;
    }
    public boolean matches(String m, String[] music, int time) {
        music[3] = music[3].replaceAll("C#", "H").replaceAll("D#", "I")
            .replaceAll("F#", "J").replaceAll("G#", "K").replaceAll("A#", "L").replaceAll("B#", "M");
        return music[3].repeat(time / music[3].length() + 2).substring(0, time).contains(m);
    }
    public int getTime(String start, String end) {
        int[] startTime = Arrays.stream(start.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] endTime = Arrays.stream(end.split(":")).mapToInt(Integer::parseInt).toArray();
        return (endTime[1] - startTime[1]) + (endTime[0] - startTime[0]) * 60;
    }
}

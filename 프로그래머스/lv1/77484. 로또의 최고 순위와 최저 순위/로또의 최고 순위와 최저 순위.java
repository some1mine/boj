import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2]; int tmp = 0;
        List<Integer> lottoList = new ArrayList<>();
        List<Integer> winList = new ArrayList<>();
        for(int i = 0 ; i < lottos.length ; i += 1) {
            lottoList.add(lottos[i]); winList.add(win_nums[i]);
        }
        /*리스트 변환*/
        for(int i : lottoList) {
            if(winList.contains(i)) tmp++;
        }
        int tmp2 = tmp;
        for(int i : lottoList) {
            if(i == 0) tmp2++;
        }
        
        answer[0] = 7 - tmp2; answer[1] = 7 - tmp;
        if(answer[0] == 7) answer[0] = 6;
        if(answer[1] == 7) answer[1] = 6;
        return answer;
    }
}
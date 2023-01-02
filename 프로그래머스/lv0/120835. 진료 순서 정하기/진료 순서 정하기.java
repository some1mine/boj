class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length]; int cnt = 1;
        while(cnt <= emergency.length) {
            int maxIdx = 0;
            for(int i = 0 ; i < emergency.length ; i++) {
                if(emergency[maxIdx] < emergency[i]) maxIdx = i;
            }
            answer[maxIdx] = cnt++;
            emergency[maxIdx] = 0;
        }
        return answer;
    }
}
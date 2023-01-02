class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1]; 
        int idx = 0, startIdx = 0, cnt = 1;
        for(int i = 0 ; i < my_str.length() ; i++) {
            if(cnt % n == 0) {
                answer[idx++] = my_str.substring(startIdx, startIdx + n);
                startIdx = i + 1;
            }
            if(cnt != my_str.length()) cnt++;
        }
        if(cnt % n != 0) answer[idx] = my_str.substring(startIdx, my_str.length());
        return answer;
    }
}
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            answer[0]++;
            int tmp = 0;
            for(char c : s.toCharArray()) {
                if(c == '0') tmp++;
            }
            s = Integer.toString("1".repeat(s.length() - tmp).length(), 2);
            answer[1] += tmp;
        }
        return answer;
    }
}
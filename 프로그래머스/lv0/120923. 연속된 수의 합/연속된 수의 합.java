class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num]; 
        int start = num % 2 == 1 ? (total / num - (num / 2)) : (total / num - (num / 2) + 1); 
        int cnt = 0;
        for(int i = start ; i < start + num ; i++) {
            answer[cnt++] = i;
        }
        return answer;
    }
}
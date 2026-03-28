class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int i : num_list) {
            answer += getNum(i);
        }
        return answer;
    }
    public int getNum(int num) {
        int answer = 0;
        while(num != 1) {
            if(num % 2 == 0) num >>= 1;
            else num = (num - 1) >> 1;
            answer++;
        }
        return answer;
    }
}
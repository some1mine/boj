class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0, cnt = 0;
        for(int i = 0 ; i < k ; i++) {
            answer = numbers[cnt];
            cnt = (cnt + 2) % numbers.length;
        }
        return answer;
    }
}
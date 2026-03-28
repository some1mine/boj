class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] powers = {5, 3, 1};
        for(int i : powers) {
            answer += hp / i;
            hp -= i * (hp / i);
        }
        return answer;
    }
}
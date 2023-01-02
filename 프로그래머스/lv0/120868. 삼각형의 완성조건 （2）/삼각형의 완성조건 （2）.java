class Solution {
    public int solution(int[] sides) {
        int answer = 0; 
        int max = sides[0] > sides[1] ? sides[0] : sides[1];
        int min = sides[0] < sides[1] ? sides[0] : sides[1];
        for(int i = 1 ; i < max + min ; i++) {
            if((i + min > max) || (i > max && (min + max) > i)) answer += 1;
        }
        return answer;
    }
}
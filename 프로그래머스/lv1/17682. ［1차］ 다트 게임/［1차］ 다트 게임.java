class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] darts = dartResult.toCharArray();
        
        int[] scores = new int[3]; int tmp = 0;
        
        for(int i = 0 ; i < darts.length ; i += 1) {
            if(darts[i] >= 48 && darts[i] < 58) {
                if(i < darts.length - 1 && darts[i] == '1' && darts[i + 1] == '0') {
                    scores[tmp++] = 10; i += 1;
                }
                else scores[tmp++] = darts[i] - 48;
            }
            else {
                switch(darts[i]) {
                    case 'S':
                        break;
                    case 'D':
                        scores[tmp - 1] *= scores[tmp - 1];
                        break;
                    case 'T':
                        scores[tmp - 1] = scores[tmp - 1] * scores[tmp - 1] * scores[tmp - 1];
                        break;
                    case '*':
                        scores[tmp - 1] *= 2;
                        if(tmp > 1) scores[tmp - 2] *= 2;
                        break;
                    case '#':
                        scores[tmp - 1] *= -1;
                        break;
                    default:
                        break;
                }
            }
        }
        
        for(int i : scores) answer += i;
        
        return answer;
    }
}
class Solution {
    public int solution(int n, String control) {
        int answer = 0;
        for(char c : control.toCharArray()) {
            switch(c) {
                case 'w':
                    n++;
                    break;
                case 's':
                    n--;
                    break;
                case 'd':
                    n += 10;
                    break;
                default:
                    n -= 10;
            }
        }
        answer = n;
        return answer;
    }
}
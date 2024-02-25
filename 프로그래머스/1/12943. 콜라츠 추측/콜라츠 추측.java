class Solution {
    public int solution(long num) {
        int i;
        for(i = 0 ; i < 500 && num != 1 ; i++) num = num % 2 == 0 ? num / 2 : num * 3 + 1;
        return num == 1 ? i : -1;
    }
}
class Solution {
    public int solution(long num) {
        return get(0, num);
    }
    public int get(int n, long num) {
        while(n++ < 500 && num != 1) num = num % 2 == 0 ? num / 2 : num * 3 + 1;
        return num == 1 ? --n : -1;
    }
}
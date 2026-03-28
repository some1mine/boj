class Solution {
    public int solution(int num, int k) {
        return Integer.toString(num).indexOf(Integer.toString(k)) + 1 == 0 ? Integer.toString(num).indexOf(Integer.toString(k)) : Integer.toString(num).indexOf(Integer.toString(k)) + 1;
    }
}
class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.chars().allMatch(c -> c >= '0' && c <= '9');
    }
}
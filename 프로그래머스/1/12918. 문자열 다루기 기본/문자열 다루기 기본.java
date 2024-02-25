import java.util.*;

class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.chars().noneMatch(c -> c > '9' || c < '0');
    }
}
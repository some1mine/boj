import java.util.*;

public class Solution {
    public int solution(int n) {
        return (int) Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).sum();
    }
}
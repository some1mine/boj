import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr) {
        return arr.length == 1 ? new int[]{-1} : Arrays.stream(arr).filter(i -> i !=  Arrays.stream(arr).min().getAsInt()).toArray();
    }
}
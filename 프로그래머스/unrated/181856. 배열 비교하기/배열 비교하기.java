import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if(arr1.length == arr2.length) {
            if(Arrays.stream(arr1).sum() > Arrays.stream(arr2).sum()) return 1;
            else if(Arrays.stream(arr1).sum() < Arrays.stream(arr2).sum()) return -1;
            else return 0;
        } else if(arr1.length > arr2.length) return 1;
        else return -1;
    }
}
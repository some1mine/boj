import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> a[col - 1] == b[col - 1] ? b[0] - a[0] : a[col - 1] - b[col - 1]);
        int answer = getData(data[row_begin - 1], row_begin);
        for(int i = row_begin ; i < row_end ; i++) answer ^= getData(data[i], i + 1);
        return answer;
    }
    public int getData(int[] arr, int i) {
        return Arrays.stream(arr).map(n -> n % i).sum();
    }
}
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        return IntStream.range(0, arr1.length).mapToObj(o -> IntStream.range(0, arr1[o].length).map(i -> arr1[o][i] + arr2[o][i]).toArray()).toArray(int[][]::new);
    }
}
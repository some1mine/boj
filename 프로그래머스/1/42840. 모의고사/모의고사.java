import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        final int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {2, 1, 2, 3, 2, 4, 2, 5}, arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, answerArr = answers;
        final boolean[][] scores = IntStream.range(0, answers.length)
            .mapToObj(n -> 
                      new boolean[]{arr1[n % arr1.length] == answerArr[n], 
                                    arr2[n % arr2.length] == answerArr[n],
                                    arr3[n % arr3.length] == answerArr[n]}).toArray(boolean[][]::new);
        final int[] result = IntStream.range(0, 3).map(i -> (int) Arrays.stream(scores).filter(a -> a[i]).count()).toArray();
        return IntStream.range(0, 3).filter(n -> result[n] == Arrays.stream(result).max().getAsInt()).map(i -> i + 1)
            .toArray();
    }
}
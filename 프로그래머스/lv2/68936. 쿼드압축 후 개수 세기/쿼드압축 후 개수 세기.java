import java.util.*;

class Solution {
    public int one = 0, zero = 0;
    public int[] solution(int[][] arr) {
        quadtree(arr, 0, 0, arr.length);
        int[] answer = {zero, one};
        return answer;
    }
    public void quadtree(int[][] arr, int offsetY, int offsetX, int length) {
        if(isEven(arr, offsetY, offsetX, length)) {
            if(arr[offsetY][offsetX] == 0) zero++;
            else one++;
            return;
        }
        quadtree(arr, offsetY, offsetX, length / 2);
        quadtree(arr, offsetY, offsetX + length / 2, length / 2);
        quadtree(arr, offsetY + length / 2, offsetX, length / 2);
        quadtree(arr, offsetY + length / 2, offsetX + length / 2, length / 2);
    }
    public boolean isEven(int[][] arr, int offsetY, int offsetX, int length) {
        int pivot = arr[offsetY][offsetX];
        for(int y = offsetY ; y < offsetY + length ; y++) {
            for(int x = offsetX ; x < offsetX + length ; x++) {
                if(arr[y][x] != pivot) return false;
            }
        }
        return true;
    }
}
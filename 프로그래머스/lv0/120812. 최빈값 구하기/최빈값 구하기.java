class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int[] arr = new int[max + 1];
        int maxIdx = 0; int maxNum = 0;
        for(int i : array) arr[i]++;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] > maxNum) {
                maxNum = arr[i]; maxIdx = i;
            }
        }
        for(int i = 0 ; i < arr.length ; i++) {
            if(i != maxIdx && arr[i] == maxNum) maxIdx = -1;
        }
        answer = maxIdx;
        return answer;
    }
}
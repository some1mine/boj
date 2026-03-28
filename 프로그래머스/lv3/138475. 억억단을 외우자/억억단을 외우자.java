class Solution {
    public int[] arr, ords;
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length]; initializeArr(e); initializeOrds(e);
        for(int i = 0 ; i < starts.length ; i++) answer[i] = ords[starts[i]];
        return answer;
    }
    public void initializeArr(int end) {
        arr = new int[end + 1];
        for(int i = 1 ; i <= end ; i++) {
            for(int j = 1 ; j <= end / i ; j++) arr[i * j]++;
        }
    }
    public void initializeOrds(int end) {
        ords = new int[end + 1]; int max = 0, maxIdx = 0;
        for(int i = end ; i > 0 ; i--) {
            if(arr[i] >= max) {
                max = arr[i]; maxIdx = i;
            }
            ords[i] = maxIdx; 
        }
    }
}
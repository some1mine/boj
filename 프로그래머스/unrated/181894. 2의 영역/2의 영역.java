class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {}; int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 2) {
                if(first == Integer.MAX_VALUE) first = i;
                last = i;
            }
        }
        if(first == Integer.MAX_VALUE) return new int[]{-1};
        answer = new int[last - first + 1]; int idx = 0;
        for(int i = first ; i <= last ; i++) answer[idx++] = arr[i];
        return answer;
    }
}
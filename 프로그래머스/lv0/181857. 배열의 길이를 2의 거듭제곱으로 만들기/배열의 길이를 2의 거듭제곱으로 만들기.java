class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[getNum(arr.length)];
        for(int i = 0 ; i < arr.length ; i++) answer[i] = arr[i];
        return answer;
    }
    public int getNum(int num) {
        for(int i = num ; ; i++) {
            if(isPow(i)) return i;
        }
    }
    public boolean isPow(int num) {
        while(num != 1) {
            if(num % 2 == 1) return false;
            num /= 2;
        }
        return true;
    }
}
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++) answer[i] = get(numbers[i]);
        return answer;
    }
    public long get(long num) {
        if(num % 2 == 0) return num + 1;
        String str = "0" + Long.toBinaryString(num);
        int idx = str.lastIndexOf("01");
        return Long.parseLong(str.substring(0, idx) + "10" + str.substring(idx + 2), 2);
    }
}
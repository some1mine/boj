class Solution {
    public int answer = 0;
    public int solution(int[] numbers, int target) {
        recursive(numbers, 0, target, 0);
        return answer;
    }
    public void recursive(int[] numbers, int sum, int target, int ord) {
        if(ord == numbers.length) {
            if(sum == target) answer++; return;
        }
        recursive(numbers, sum + numbers[ord], target, ord + 1);
        recursive(numbers, sum - numbers[ord], target, ord + 1);
    }
}
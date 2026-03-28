class Solution {
    public int solution(String binomial) {
        int answer = 0;
        if(binomial.contains("+")) {
            String[] arr = binomial.split("\\+");
            answer = Integer.parseInt(arr[0].trim()) + Integer.parseInt(arr[1].trim());
        } else if(binomial.contains("-")) {
            String[] arr = binomial.split("-");
            answer = Integer.parseInt(arr[0].trim()) - Integer.parseInt(arr[1].trim());
        } else {
            String[] arr = binomial.split("\\*");
            answer = Integer.parseInt(arr[0].trim()) * Integer.parseInt(arr[1].trim());
        }
        return answer;
    }
}
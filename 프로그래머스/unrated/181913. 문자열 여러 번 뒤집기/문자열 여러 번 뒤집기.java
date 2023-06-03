class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int[] query : queries) {
            my_string = reverse(my_string, query[0], query[1]);
        }
        return my_string;
    }
    public String reverse(String str, int n1, int n2) {
        char[] arr = str.toCharArray();
        for(int i = n1 ; i <= (n1 + n2) / 2 ; i++) {
            char tmp = arr[i]; arr[i] = arr[n2 - (i - n1)]; arr[n2 - (i - n1)] = tmp;
        }
        return new String(arr);
    }
}
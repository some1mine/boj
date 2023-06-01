class Solution {
    public String solution(String my_string, int s, int e) {
        return reverse(my_string, s, e);            
    }
    public String reverse(String str, int a, int b) {
        char[] arr = str.toCharArray();
        for(int i = a ; i < (a + b) / 2 + 1 ; i++) {
            char c = arr[i]; arr[i] = arr[b - (i - a)]; arr[b - (i - a)] = c;
        }
        return new String(arr);
    }
}
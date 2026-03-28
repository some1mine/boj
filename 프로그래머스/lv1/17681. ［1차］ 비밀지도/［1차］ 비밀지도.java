class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];
        
        for(int i = 0 ; i < n ; i += 1){
            strArr1[i] = Integer.toBinaryString(arr1[i]);
            strArr2[i] = Integer.toBinaryString(arr2[i]);
        }
        for(int i = 0 ; i < n ; i += 1) {
            int len1 = strArr1[i].length(), len2 = strArr2[i].length();
            for(int j = 0 ; j < n - len1 ; j += 1)
                strArr1[i] = "0" + strArr1[i];
            for(int j = 0 ; j < n - len2 ; j += 1)
                strArr2[i] = "0" + strArr2[i];
        }
        for(int i = 0 ; i < n ; i += 1) {
            String tmp = "";
            for(int j = 0 ; j < n ; j += 1) {
                if(strArr1[i].charAt(j) == '0' && strArr2[i].charAt(j) == '0') tmp += " ";
                else tmp += "#";
            }
            answer[i] = tmp;
        }
        return answer;
    }
}
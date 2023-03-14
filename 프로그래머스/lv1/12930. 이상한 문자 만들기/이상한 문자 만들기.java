class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int cnt = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr[i].length() ; j++){
                if(j % 2 == 0){
                    if(arr[i].charAt(j) < 97){
                        answer += Character.toString(arr[i].charAt(j));
                    } else{
                        answer += Character.toString(arr[i].charAt(j) - 32);
                    }
                } else{
                    if(arr[i].charAt(j) >= 97){
                        answer += Character.toString(arr[i].charAt(j));
                    } else{
                        answer += Character.toString(arr[i].charAt(j) + 32);
                    }
                }
            }
            answer += " ";
        }
        answer = answer.trim();
        if(s.charAt(0) == ' '){
            answer = " " + answer;
        }
        if(s.charAt(s.length()-1) == ' ') {
            answer += " ";
        }
        if(s.length() > answer.length()) answer += s.substring(answer.length());
        return answer;
    }
}
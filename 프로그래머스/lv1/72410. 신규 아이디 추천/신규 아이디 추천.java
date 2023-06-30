class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        // 1단계
        answer = new_id.toLowerCase();
        // 2단계
        answer = removeOthers(answer);
        // 3단계
        answer = answer.replaceAll("\\.+", ".");
        // 4단계
        answer = trimer(answer);
        // 5단계
        if(answer.isEmpty()) answer = "a";
        // 6단계
        if(answer.length() > 15) answer = answer.substring(0, 15);
        answer = endTrimer(answer);
        // 7단계
        if(answer.length() < 3) answer = repeat(answer);
        return answer;
    }
    public String repeat(String str) {
        char c = str.charAt(str.length() - 1);
        while(str.length() != 3) str += c;
        return str;
    }
    public String endTrimer(String str) {
        if(str.endsWith(".")) str = str.substring(0, str.length() - 1);
        return str;
    }
    public String trimer(String str) {
        if(str.startsWith(".")) str = str.substring(str.indexOf(".") + 1);
        if(str.endsWith(".")) str = str.substring(0, str.length() - 1);
        return str;
    }
    public String removeOthers(String str) {
        String verify = "0123456789abcdefghijklmnopqrstuvwxyz-_.";
        for(String s : str.split("")) {
            if(!verify.contains(s)) str = str.replace(s, "@");
        }
        return str.replace("@", "");
    }
}
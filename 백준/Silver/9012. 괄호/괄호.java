import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
                      
        String[] arr = new String[len];
        
        for(int i = 0 ; i < len ; i++) {
            arr[i] = br.readLine();
        }
        outLoop:
        for(String s : arr) {
            if(s.startsWith(")") || s.endsWith("(") ) System.out.println("NO");
            else {
                int left = 0; int right = 0;
                for(char c : s.toCharArray()) {
                    if(c == '(') left++;
                    else if(c ==')') right++;
                    if(right > left) {
                        System.out.println("NO");
                        continue outLoop;
                    }
                }
                if(left == right) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < len ; i++) {
            if(len == (int)Math.pow(2, i)) {
                System.out.println(len);
                break;
            }
            else if(len / (int)Math.pow(2, i) == 0) {
                System.out.println((len % (int)Math.pow(2, i - 1)) * 2);
                break;
            }
        }
    }
}
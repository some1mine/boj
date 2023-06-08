import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = reader.readLine().split("");
    int answer = 0;
    int stack = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("(")) stack++;
      else {
        stack--;
        if(arr[i - 1].equals("(")) answer += stack;
        else answer++;
      }
    }
    System.out.println(answer);
  }
}
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int cnt = 0;
        int i;
        for(i=666;i<100000000;i++){
            if((i+"").contains("666")){
                cnt++;
                }
            if(cnt == a) {
                break;  
                }
         }
     System.out.println(i);
  }
}
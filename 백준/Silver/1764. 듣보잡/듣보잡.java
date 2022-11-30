import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       
       List<String> list1 = new ArrayList<>();
       List<String> list2 = new ArrayList<>();
       
       for(int i = 0 ; i < N ; i += 1) list1.add(sc.next());

       Collections.sort(list1);
       String[] arr1 = new String[list1.size()];
       arr1 = list1.toArray(arr1);
       
       for(int i = 0 ; i < M ; i += 1) {
    	   String s = sc.next();
    	   int num = Arrays.binarySearch(arr1, s);
    	   if(num >= 0) list2.add(s);
       }
       
       Collections.sort(list2);
       System.out.println(list2.size());
       for(String s : list2)  System.out.println(s);  
    }
}
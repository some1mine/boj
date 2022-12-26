import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
        String[] arr = new String[len];
        for(int i = 0 ; i < len ; i++) {
            arr[i] = br.readLine();
        }
        List<Integer> list = new ArrayList<>();
        
        for(String s : arr) {
            switch(s.substring(0,3)) { 
                    case "pus" :
                                          list.add(Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())));
                                          break;
                     case "pop" :
                                                   if(list.size() == 0) {
                                                       System.out.println(-1);
                                                       break;
                                                   }
                                          System.out.println(list.get(list.size()-1));
                                          list.remove(list.size()-1);
                                          break;
                    case "siz" :
                                          System.out.println(list.size());
                                                   break;
                    case "emp":
                                          System.out.println(list.size() == 0 ? 1 : 0);     
                                                   break;
                                      
                    case "top":
                                                   if(list.size() == 0) {
                                                       System.out.println(-1);
                                                       break;
                                                   }
                                                   System.out.println(list.get(list.size()-1));
                    break;
            }
        }
    }
}
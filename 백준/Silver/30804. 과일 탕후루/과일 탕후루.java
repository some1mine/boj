import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int maxNum =1,tmp=1,stack=1;
        int N =Integer.parseInt(nums[0]);
        Queue<Integer>queue =new LinkedList<>();
        nums = br.readLine().split(" ");
        queue.add(Integer.parseInt(nums[0]));
        for(int i=1;i<N;i++){
            int num=Integer.parseInt(nums[i]);
            if(queue.contains(num)){
                if(queue.peek()==num){ 
                    if(queue.size()==2){
                    queue.poll();

                    queue.add(num);
                    stack=0;
                }}
            }
            else{
                if(queue.size()==1){
                    queue.add(num);
                    stack=0;
                }
                else{
                    queue.poll();
                    tmp = stack;
                    stack=0;
                    queue.add(num);
                }
            }
            stack++;
            tmp++;
            if (maxNum<tmp){
                maxNum=tmp;
            }
        }
        br.close();
        System.out.print(maxNum);
    }
}
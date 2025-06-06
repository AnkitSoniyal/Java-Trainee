import java.util.*;

public class Stream_use {
  
    public static void main(String[] args) {
       //imperative approach
       int []arr={1,2,3,4,};
       int sum=0;
       for(int i=0;i<arr.length;i++){
         if(arr[i]%2==0){
           sum+=arr[i];
         }
       }
       
       //stream use
       int sum2=Arrays.stream(arr).filter(n->n%2==0).sum();
       System.out.print(sum2);

  }
}
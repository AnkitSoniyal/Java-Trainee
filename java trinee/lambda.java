import java.util.*;
interface demoano{
  public void m1();
  //public void m2();
}

public class lambda {
  
    public static void main(String[] args) {
       //anonymous class
       demoano ob=new demoano(){
         public void m1(){
          System.out.println("Message1"); 
         }
        /* public void m2(){
          System.out.println("Message2"); 
         }*/
       };
       ob.m1();
       
       //lambda function
       demoano obj=()->{System.out.println("Message1");};
  }
}
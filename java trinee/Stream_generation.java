import java.util.*;
import java.util.stream.*;
public class Stream_generation {
  
    public static void main(String[] args) {
      List<String> s=Arrays.asList("apple","banana","coconut");
      Stream<String> s1=s.stream();
       s1.forEach(System.out::println);
       
       String[] arr={"apple","banana","coconut"};
       Stream<String> s2=Arrays.stream(arr);
       s2.forEach(System.out::println);
       
       Stream<Integer> i=Stream.of(1,2,3,4,5);
       i.forEach(System.out::println);
       
       Stream<Integer> j=Stream.iterate(0,n->n+1).limit(100);
       j.forEach(System.out::print);
       System.out.println();
       
       Stream<Integer> k=Stream.generate(()->(int)Math.random()).limit(100);
       k.forEach(System.out::print);


  }
}
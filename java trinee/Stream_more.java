import java.util.*;
import java.util.stream.*;
public class Stream_more{
  
    public static void main(String[] args) {
      List<Integer> a=Arrays.asList(9,3,45,134,563,17876,44,24,66,3,12,77,6,4,21,12,54,15354);
      List<Integer> filteredlist=a.stream()
                                  .filter(x->x%2==0)
                                  .peek(x->System.out.println(x))
                                  .sorted()
                                  .distinct()
                                  .peek(x->System.out.println(x))
                                  .collect(Collectors.toList());


  }
}
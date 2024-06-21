import java.util.*;
import java.util.stream.*;
public class CreateStream {
      public static void main(String[] args) {
        


        // 1.Blank Stream 
        Stream<Object> entryStream =Stream.empty();
        //for each takes a mathod which do not return anything
        entryStream.forEach(e->{System.out.println(e);});


       
        //2.Array Conversion
        String names[]={"DUGESH","UTTAM","ANKIT","DIVYA"};
        Stream<String> stream1=Stream.of(names);
        stream1.forEach(e->System.out.println(e));


        
        //3.Builder
        Stream<Object> streamBuilder=Stream.builder().build();
        
        
        //4.IntStream (converts integer array)
        IntStream stream=Arrays.stream(new int[]{2,3,4,43});
        stream.forEach(e->System.out.println());
        

       
        //5.List,Set
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Stream<Integer> stream2 =list.stream();
        stream2.forEach(e->{System.out.println(e);});

      }
}

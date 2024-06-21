
/**
 * With_Vs_Without
 */
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class With_Vs_Without {

    public static void main(String[] args) {

        // Q.Create a list and filter all the even elements.

        // This is without Using Streams
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> newevenlist = new ArrayList<>();

        for (int i : list) {
            if (i % 2 == 0) {
                newevenlist.add(i);
            }
        }

        // Using Streams
        List<Integer> newevenlist2 = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        System.out.println(newevenlist2);

        List<Integer> newevenlist3 = list.stream().filter(e -> e > 10).collect(Collectors.toList());
        System.out.println(newevenlist3);

        // Using Anonymous Inner Class //but we always use lamda function
        List<Integer> newevenlist4 = list.stream().filter(new Predicate<Integer>() {

            @Override
            public boolean test(Integer t) {

                return t > 10;
            }

        }).collect(Collectors.toList());
        System.out.println(newevenlist4);
    }

}
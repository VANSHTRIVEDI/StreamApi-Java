import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Properties_Of_Oops.object_cloning.A;

public class ImportantMethods {
    public static void main(String[] args) {

        /*
         * List<String> names = List.of("Aman", "Ankit", "Abhinav", "Durgesh");
         * System.out.println(names);
         * This is not possible because list.of create a immutable list
         * names.add("Vansh");
         */

        /*
         * filter function (Predicate)
         * Filter return only return a boolean statement
         * if takes a variable and checks for that boolean statement
         */

        List<String> names = List.of("Aman", "Ankit", "Abhinav", "Durgesh");

        names = names.stream().filter(e -> e.charAt(0) == 'A').collect(Collectors.toList());
        System.out.println(names);

        /*
         * map function
         * map function takes varibale and return a value
         */
        List<Integer> number = List.of(1, 2, 3, 4);
        number = number.stream().map(e -> e * e).collect(Collectors.toList());
        System.out.println("List of Square of number" + number);

        // Collectors have many such function like joining,summingInt,groupingBy
        String joined = number.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(joined);

        /*
         * for each
         * it takes variable and traverse all them and return nothing
         */

        List<Integer> num = List.of(5, 4, 3, 1);
        num.stream().forEach(e -> System.out.println(e));

        // sort a list
        num.stream().sorted().forEach(e -> System.out.println(e));

        // both are same
        num.stream().sorted().forEach(System.out::println);

        // max function and min function
        /*
         * use to find min and max
         * take a value and finds which is min or max using comaprator
         */

        Integer max = num.stream().max((a, b) -> a.compareTo(b)).get();

        int nums[] = { 1, 2, 3, };
        int max2 = Arrays.stream(nums).max().getAsInt();

        // using method refence below
        int max3 = num.stream().max(Integer::compareTo).get();

        Integer min = num.stream().min((a, b) -> a.compareTo(b)).get();

        /*
         * here nums is an array
         * int max2= Arrays.stream(nums).max().getAsInt();
         * 
         * here nums is list
         * int max3=num.stream().max().getAsInt
         * 
         * why in array it is working without comparator and why in list is is not
         * 
         * 
         * 
         * answer
         * 
         * 
         * Primitive Arrays (int[]):
         * 
         * Arrays.stream(nums) creates an IntStream.
         * IntStream has a max() method that does not require a comparator because it
         * deals with primitive types with natural ordering.
         * Lists (List<Integer>):
         * 
         * num.stream() creates a Stream<Integer>.
         * Stream<Integer>'s max() method requires a comparator because it deals with
         * objects, and the comparison logic needs to be specified.
         */

    }
}

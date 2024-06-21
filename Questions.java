import java.util.*;

public class Questions {

    // Largest Element in Array
    public int largest(int arr[], int n) {
        return Arrays.stream(arr).max().getAsInt();
    }

    // Second Largest in Array
    int print2largest(int nums[], int n) {
        int max = Arrays.stream(nums).max().getAsInt();

        return Arrays.stream(nums).filter(e -> e != max).max().orElse(-1);
        // Here you dont have to convert it into int using getAsInt because orElse
        // function will do that unwrapping of OptionalInt which is returend by
        // array.stream().max()
    }

    // removeDuplicates of array and return its count
    public int removeDuplicates(int[] nums) {

        int distinctElements[] = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(distinctElements, 0, nums, 0, distinctElements.length);

        return distinctElements.length;
    }

    // Using streams to check if the element is present in the array
    // boolean isPresent = Arrays.stream(nums).anyMatch(x -> x == elementToFind);
    // for String
    // boolean isPresent = Arrays.stream(words).anyMatch(x
    // ->x.equals(elementToFind));
    static int searchInSorted(int arr[], int N, int K) {

        return Arrays.stream(arr).anyMatch(e -> e == K) ? 1 : -1;

    }

}

import java.util.Arrays;
import java.util.List;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44);

        int left = 0;
        int right = numbers.size() - 1;

        while (left < right) {
            int temp = numbers.get(left);
            numbers.set(left, numbers.get(right));
            numbers.set(right, temp);

            left++;
            right--;
        }

        System.out.println(numbers);
    }
}

import java.util.Arrays;

public class RemoveDuplicatesSorted {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int writeIndex = 1;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));
        // Length = 5
        // [1, 2, 3, 4, 5]
    }
}

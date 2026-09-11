import java.util.Arrays;

public class L5RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] rotatedArray =
                new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int newPosition =
                    (i + k) % nums.length;

            rotatedArray[newPosition] = nums[i];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[] nums = {
            1, 2, 3, 4, 5, 6, 7
        };

        int k = 3;

        int[] result =
                rotateArray(nums, k);

        System.out.println(Arrays.toString(result));
    }
}

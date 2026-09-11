import java.util.Arrays;

public class ArrayPractice {

    // L1. Two Sum
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // L2. Best Time to Buy and Sell Stock
    static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - lowestPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }

        return maximumProfit;
    }

    // L3. Contains Duplicate
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    // L4. Merge Two Sorted Arrays
    static int[] mergeSortedArrays(
            int[] arr1,
            int[] arr2) {

        int[] result =
                new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    // L5. Rotate Array
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
        int[] twoSumArray = {2, 7, 11, 15};
        System.out.println(
                "Two Sum: "
                        + Arrays.toString(
                                twoSum(twoSumArray, 9)
                        )
        );

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(
                "Maximum Profit: "
                        + maxProfit(prices)
        );

        int[] duplicateArray = {1, 2, 3, 1};
        System.out.println(
                "Contains Duplicate: "
                        + containsDuplicate(duplicateArray)
        );

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        System.out.println(
                "Merged Array: "
                        + Arrays.toString(
                                mergeSortedArrays(arr1, arr2)
                        )
        );

        int[] rotateInput = {
            1, 2, 3, 4, 5, 6, 7
        };

        System.out.println(
                "Rotated Array: "
                        + Arrays.toString(
                                rotateArray(rotateInput, 3)
                        )
        );
    }
}

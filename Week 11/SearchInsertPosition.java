public class SearchInsertPosition {

    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};

        System.out.println(searchInsertPosition(nums, 5)); // 2
        System.out.println(searchInsertPosition(nums, 2)); // 1
    }
}

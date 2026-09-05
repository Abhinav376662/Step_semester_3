import java.util.Scanner;

public class MaximumSubarray {
    
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        
        // Kadane's algorithm: extend or restart at each step
        for (int i = 1; i < nums.length; i++) {
            // Either extend current subarray or start fresh from current element
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update global maximum
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        
        return maxSoFar;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int result = maxSubArray(nums);
        
        System.out.println("Maximum Subarray Sum: " + result);
        
        sc.close();
    }
}

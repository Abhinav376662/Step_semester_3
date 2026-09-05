import java.util.Scanner;

public class FindMinRotated {
    
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // Modified binary search for rotated array
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If middle element is less than right, minimum is in left half (including mid)
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            // If middle element is greater than right, minimum is in right half (excluding mid)
            else {
                left = mid + 1;
            }
        }
        
        // When left == right, we found the minimum
        return nums[left];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        System.out.println("Enter " + n + " sorted rotated integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        int result = findMin(nums);
        
        System.out.println("Minimum element: " + result);
        
        sc.close();
    }
}

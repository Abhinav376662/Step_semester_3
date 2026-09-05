import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
    
    public static int subarraySum(int[] nums, int k) {
        // HashMap to store frequency of prefix sums
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        
        // Base case: empty prefix has sum 0
        prefixSumFreq.put(0, 1);
        
        int count = 0;
        int currentSum = 0;
        
        for (int num : nums) {
            // Update running prefix sum
            currentSum += num;
            
            // Check if (currentSum - k) exists in map
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }
            
            // Update frequency of current prefix sum
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
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
        
        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();
        
        int result = subarraySum(nums, k);
        
        System.out.println("Number of subarrays with sum " + k + ": " + result);
        
        sc.close();
    }
}

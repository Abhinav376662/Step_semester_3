import java.util.Scanner;

public class ProductExceptSelf {
    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Forward pass: accumulate product of everything to the left
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // Backward pass: multiply in product of everything to the right
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
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
        
        int[] result = productExceptSelf(nums);
        
        System.out.print("Output: [");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        sc.close();
    }
}

import java.util.Scanner;

public class ReverseCustomerName {
    
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0, right = chars.length - 1;
        
        // Reverse the character array in-place
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("\n=== Customer Identity Verification ===");
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
        
        sc.close();
    }
}

import java.util.Scanner;

public class ISBNValidator {
    
    public static String normalizeCode(String raw) {
        // Trim leading/trailing spaces
        String trimmed = raw.trim();
        
        // Uppercase first 3 characters (publisher code)
        if (trimmed.length() >= 3) {
            String publisher = trimmed.substring(0, 3).toUpperCase();
            String rest = trimmed.substring(3);
            return publisher + rest;
        }
        
        return trimmed;
    }
    
    public static String validateAndFormat(String code) {
        System.out.println("\n=== Library ISBN Validator ===\n");
        
        // Check exact length
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters (found " + code.length() + ")";
        }
        
        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        
        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: catalog number must be 10 digits";
            }
        }
        
        // Build formatted display line
        StringBuilder formatted = new StringBuilder();
        formatted.append("[")
                .append(code.substring(0, 3))
                .append("] YEAR: ")
                .append(code.substring(3, 7))
                .append(" | CATALOG: ")
                .append(code.substring(7, 13));
        
        return formatted.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter ISBN code: ");
        String rawCode = sc.nextLine();
        
        String normalized = normalizeCode(rawCode);
        String result = validateAndFormat(normalized);
        
        System.out.println(result);
        
        sc.close();
    }
}

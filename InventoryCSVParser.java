import java.util.Scanner;

public class InventoryCSVParser {
    
    public static void parseInventoryRecord(String csvLine) {
        System.out.println("\n=== Product Inventory CSV Parser ===\n");
        
        // Split CSV line into fields
        String[] fields = csvLine.split(",");
        
        // Validate exactly 3 fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        
        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();
        
        // Print formatted record
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", 
                         productName, sku, quantity);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter CSV record (ProductName,SKU,Quantity): ");
        String csvLine = sc.nextLine();
        
        parseInventoryRecord(csvLine);
        
        sc.close();
    }
}

import java.util.Scanner;

public class WarehouseInventoryBalancer {
    
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        System.out.println("\n=== Warehouse Inventory Balancer ===\n");
        
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Sections must have equal number of items!");
            return;
        }
        
        // Compute totals
        int totalA = 0, totalB = 0;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
        }
        
        // Find highest quantity
        int highestQty = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 1;
        
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }
        
        // Print results
        System.out.printf("Section A Total: %d | Section B Total: %d | ", totalA, totalB);
        
        if (totalA == totalB) {
            System.out.print("Status: Balanced | ");
        } else {
            System.out.print("Status: Not Balanced | ");
        }
        
        System.out.printf("Highest Quantity: %d (%s, Item %d)%n", 
                         highestQty, highestSection, highestIndex);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of item categories: ");
        int n = sc.nextInt();
        
        int[] sectionA = new int[n];
        int[] sectionB = new int[n];
        
        System.out.println("\nEnter quantities for Section A:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionA[i] = sc.nextInt();
        }
        
        System.out.println("\nEnter quantities for Section B:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionB[i] = sc.nextInt();
        }
        
        analyzeInventory(sectionA, sectionB);
        
        sc.close();
    }
}

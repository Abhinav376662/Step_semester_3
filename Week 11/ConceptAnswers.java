public class ConceptAnswers {

    public static void main(String[] args) {
        System.out.println("Question 1:");
        System.out.println("Primitive structures store one basic value directly, such as a char 'A'.");
        System.out.println("Non-primitive structures organize collections, such as Map<String, Double> for product prices.");

        System.out.println("\nQuestion 2:");
        System.out.println("A linked list is linear logically because each node has at most one predecessor and successor.");
        System.out.println("Non-contiguous memory affects storage, not its logical linear sequence.");

        System.out.println("\nQuestion 3:");
        System.out.println("Independent loops add costs: O(m + n).");
        System.out.println("Nested loops multiply costs: O(m * n).");

        System.out.println("\nQuestion 4:");
        System.out.println("A web app can cache user profiles in a hash map.");
        System.out.println("It uses more memory to reduce frequent database lookups to near O(1) access time.");

        System.out.println("\nQuestion 5:");
        System.out.println("Hash map: average O(1) lookup, insert, delete; no guaranteed order.");
        System.out.println("Sorted array: O(log n) search and ordered/range queries; O(n) insert/delete due to shifting.");
    }
}

import java.util.Arrays;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int currentBook = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > currentBook) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = currentBook;

            System.out.println("After placing " + currentBook + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        int[] books1 = {30, 10, 40, 20};
        System.out.println("Sample Input:");
        shelf(books1);

        System.out.println();

        int[] books2 = {50, 25, 75, 10, 60};
        System.out.println("Custom Input:");
        shelf(books2);
    }
}

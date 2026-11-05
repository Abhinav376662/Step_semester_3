public class QueueOrderCheck {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1)); // 4

        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2)); // -1

        int[] tokens3 = {10, 8, 12};
        System.out.println(firstBreak(tokens3)); // 1

        int[] tokens4 = {};
        System.out.println(firstBreak(tokens4)); // -1

        int[] tokens5 = {4};
        System.out.println(firstBreak(tokens5)); // -1
    }
}

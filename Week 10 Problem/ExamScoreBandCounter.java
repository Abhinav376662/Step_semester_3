public class ExamScoreBandCounter {

    public static int countInBand(int[] scores, int low, int high) {
        int first = firstIndexAtLeast(scores, low);
        int afterLast = firstIndexGreaterThan(scores, high);

        return afterLast - first;
    }

    // First index where score >= low
    private static int firstIndexAtLeast(int[] scores, int low) {
        int left = 0;
        int right = scores.length;
        int answer = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] >= low) {
                answer = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    // First index where score > high
    private static int firstIndexGreaterThan(int[] scores, int high) {
        int left = 0;
        int right = scores.length;
        int answer = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] > high) {
                answer = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}

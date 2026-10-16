public class BusiestBusRow {

    public static int[] busiestRow(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int bestRowIndex = 0;
        int bestRowTotal = 0;

        for (int i = 0; i < rows; i++) {
            int rowTotal = 0;

            for (int j = 0; j < columns; j++) {
                rowTotal += grid[i][j];
            }

            // Strictly larger ensures the smaller index wins in a tie
            if (rowTotal > bestRowTotal) {
                bestRowTotal = rowTotal;
                bestRowIndex = i;
            }
        }

        return new int[]{bestRowIndex, bestRowTotal};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        int[] result = busiestRow(grid);

        System.out.println("Row " + result[0] + ", Total " + result[1]);
    }
}

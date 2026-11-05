public class WarehouseSummary {

    public static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxValue = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                total += grid[row][col];

                if (grid[row][col] > maxValue) {
                    maxValue = grid[row][col];
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        return new int[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        int[] result = warehouseSummary(grid);

        System.out.println("Total = " + result[0]);
        System.out.println("Max coordinate = (" + result[1] + ", " + result[2] + ")");
    }
}

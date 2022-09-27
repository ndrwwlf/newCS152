public class inclass919 {
    public static void main(String[] args) {


        int[] a = new int[10];

        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;

        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];

        System.out.println(a[5]);


        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int bombs = Integer.parseInt(args[2]);

        boolean[][] grid = new boolean[m + 2][n + 2];
//        int[][] bombCount = new int[m][n];

        int[][] board = new int[m][n];

        //fill grid
        while (bombs > 0) {

//            int x = StdRandom.uniformInt(m);
//            int y = StdRandom.uniformInt(n);
            int x = (int) (Math.random() * (m - 2));
            int y = (int) (Math.random() * (m - 2));

            if (!grid[x + 1][y + 1]) {

                grid[x + 1][y + 1] = true;
                board[x][y] = -1;
                bombs--;
            }

        }

        for (int i = 1; i < grid.length - 2; i++) {

            for (int j = 1; j < grid[i].length - 2; j++) {

//                if (grid[i][j]) {
////                    board[i][j] = -1;
////                    break;
//                }

                int count = 0;

                if (grid[i - 1][j - 1]) count++;
                if (grid[i][j - 1]) count++;
                if (grid[i + 1][j - 1]) count++;
                if (grid[i - 1][j]) count++;
                if (grid[i + 1][j]) count++;
                if (grid[i - 1][j + 1]) count++;
                if (grid[i][j + 1]) count++;
                if (grid[i + 1][j + 1]) count++;

                if (!grid[i][j]) {
                    board[i - 1][j - 1] = count;
                }
            }

        }

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == -1) {
                    StdOut.print("*  ");
                } else {
                    StdOut.print(board[i][j] + "  ");
                }
            }

            StdOut.println();
        }

    }
}

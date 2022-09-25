public class Minesweeper {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int bombs = Integer.parseInt(args[2]);

        boolean[][] grid = new boolean[n + 2][m + 2];
//        int[][] bombCount = new int[m][n];

        int[][] board = new int[n][m];

        //fill grid
        while (bombs > 0) {

//            int x = StdRandom.uniformInt(m);
//            int y = StdRandom.uniformInt(n);
            int x = (int) (Math.random() * (n));
            int y = (int) (Math.random() * (m));

            if (!grid[x + 1][y + 1]) {

                grid[x + 1][y + 1] = true;
                board[x][y] = -1;
                bombs--;
            }

        }

        for (int i = 1; i < grid.length - 1; i++) {

            for (int j = 1; j < grid[i].length - 1; j++) {

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

//public class Minesweeper {
//    public static void main(String[] args) {
//
//        int m = Integer.parseInt(args[0]);
//        int n = Integer.parseInt(args[1]);
//        int bombs = Integer.parseInt(args[2]);
//
//        boolean[][] grid = new boolean[m][n];
////        int[][] bombCount = new int[m][n];
//
//        int[][] board = new int[m][n];
//
//        //fill grid
//        while (bombs > 0) {
//
////            int x = StdRandom.uniformInt(m);
////            int y = StdRandom.uniformInt(n);
//            int x = (int) (Math.random() * m);
//            int y = (int) (Math.random() * n);
//
//            if (!grid[x][y]) {
//
//                grid[x][y] = true;
//                bombs--;
//            }
//
//        }
//
////        for (int i = 0; i < grid.length; i++) {
////
////            for (int j = 0; j < grid[i].length; j++) {
////
////                if (grid[i][j]) {
////                    StdOut.print("*  ");
////                } else {
////                    StdOut.print("O  ");
////                }
////            }
////
////            StdOut.println();
////        }
//
////        for (int i = 0; i < grid.length; i++) {
////
////            for (int j = 0; j < grid[i].length; j++) {
////
////                if (grid[i][j]) {
////                    board[i][j] = -1;
////                }
////                int count = 0;
////                if (j == 0) {
////
////                    if (i == 0) {
////
////                        if (grid[i + 1][j]) {
////                            count++;
////                        }
////                        if (grid[i][j + 1]) {
////                            count++;
////                        }
////                        if (grid[i + 1][j + 1]) count++;
////                    }
////                    if (i == grid.length - 1) {
////
////                        if (grid[i + 1][j]) {
////                            count++;
////                        }
////                        if (grid[i][j + 1]) {
////                            count++;
////                        }
////                        if (grid[i - 1][i + 1]) count++;
////                    }
////                }
////
////                board[i][j] = count;
////            }
////        }
//
//        for (int i = 0; i < board.length; i++) {
//
//            for (int j = 0; j < board[i].length; j++) {
//
//                if (board[i][j] == -1) {
//                    StdOut.print("*  ");
//                } else {
//                    StdOut.print(board[i][j] + "  ");
//                }
//            }
//
//            StdOut.println();
//        }
//
//    }
//}

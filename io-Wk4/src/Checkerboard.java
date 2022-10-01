public class Checkerboard {
    public static void main(String[] args) {

        //I found this at https://www.cs.princeton.edu/courses/archive/spr19/cos126/precepts/p5b-stddraw/sol/Checkerboard.java
        //Had to research StdDraw.filledSquare, and it makes sense to me now
        int n = Integer.parseInt(args[0]);

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (((i + j) % 2) != 0) {

                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else {

                    StdDraw.setPenColor(StdDraw.BLUE);
                }

                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }
}

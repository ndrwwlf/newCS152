public class Checkerboard {
    public static void main(String[] args) {

        //I found this at https://www.cs.princeton.edu/courses/archive/spr19/cos126/precepts/p5b-stddraw/sol/Checkerboard.java
        //Had to research StdDraw.setXscale and it makes sense to me now
        int n = Integer.parseInt(args[0]);

        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);

        boolean blue = true;
        boolean columnSwitch = false;
        int cellCt = 0;

        // Draw from lower left, up and across.
        // i is the index for the x value; j is the index for y.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i + j) % 2) != 0) {
//                if (!blue && !columnSwitch) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                } else
                    StdDraw.setPenColor(StdDraw.BLUE);

            
                cellCt++;
                // draw filled square centered at ___, ___ with radius 0.5
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
//            if (cellCt % n == 0) {
//                columnSwitch = true;
//            } else {
//                columnSwitch = false;
//            }
        }
    }
}

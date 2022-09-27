public class WorldMap {
    public static void main(String[] args) {

        int xCanvas = StdIn.readInt();
        int yCanvas = StdIn.readInt();

        StdDraw.setCanvasSize(xCanvas, yCanvas);
        StdDraw.setXscale(0, xCanvas);
        StdDraw.setYscale(0, yCanvas);

        StdDraw.enableDoubleBuffering();

//        StdDraw.line(0, .5, .3, .9);
        while (!StdIn.isEmpty()) {

            StdIn.readString();

            int numberOfVertices = StdIn.readInt();
            double[] verticesX = new double[numberOfVertices];
            double[] verticesY = new double[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                verticesX[i] = StdIn.readDouble();
                verticesY[i] = StdIn.readDouble();
            }

            StdDraw.polygon(verticesX, verticesY);
        }
        StdDraw.show();
//        while (!StdIn.isEmpty()) {
//
//
//        }
    }
}

public class WorldMap {
    public static void main(String[] args) {


        // I was looking/googling for a way to skip over reading the string with the state abbreviations and I stumbled
        // across a pretty much exact solution for this problem on github. I already had the other logic in my head ready to go
        // I felt dumb when I saw that I could just handle the abbreviation strings by reading them in but not doing
        // anything with them. But this all makes sense now.
        
        int x = StdIn.readInt();
        int y = StdIn.readInt();

        StdDraw.setCanvasSize(x, y);
        StdDraw.setXscale(0, x);
        StdDraw.setYscale(0, y);

        StdDraw.enableDoubleBuffering();

        while (!StdIn.isEmpty()) {

            StdIn.readString();

            int verts = StdIn.readInt();
            double[] xCoords = new double[verts];
            double[] yCoords = new double[verts];

            for (int i = 0; i < verts; i++) {

                xCoords[i] = StdIn.readDouble();
                yCoords[i] = StdIn.readDouble();
            }

            StdDraw.polygon(xCoords, yCoords);
        }

        StdDraw.show();
    }
}

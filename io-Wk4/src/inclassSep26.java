public class inclassSep26 {
    public static void main(String[] args) {
//        int N = (int) (44100 * 11.0);
//        double[] a = new double[N + 1];
//        for (int i = 0; i <= N; i++)
//            a[i] = Math.random();
//        StdAudio.play(a);
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            if (!StdIn.isEmpty()) x += StdIn.readInt();
            StdOut.print(x + " ");
        }
        StdOut.println();
    }
}

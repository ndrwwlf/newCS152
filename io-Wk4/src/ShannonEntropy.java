public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        double h = 0.0;
        int[] freq = new int[m + 1];
        int count = 0;


        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();
//            String line = StdIn.readLine();
//            int[] split = new int[line.split(" ").length];
//            for (int i = 0; i < split.length; i++) {
//                split[i] = Integer.parseInt(line.split(" ")[i]);
//            }


            freq[p]++;
            count++;

//            h += (p * Math.log(p) / Math.log(2));
        }

        for (int i = 1; i < freq.length; i++) {

            if (freq[i] > 0) {
                double pSubi = freq[i] / (double) count;
//            h += pSubi;
                h += -1 * (pSubi * Math.log(pSubi) / Math.log(2));
            }
        }

        StdOut.printf("%.4f\n", h);

    }
}

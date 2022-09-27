public class SHThree {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        double h = 0.0;
        int[] freq = new int[m + 1];
        int count = 0;

        while (!StdIn.isEmpty()) {
            
            int p = StdIn.readInt();
            freq[p]++;
            count++;
        }

        for (int i = 1; i < freq.length; i++) {

            double pSubi = freq[i] / (double) count;
            h += -1 * (pSubi * Math.log(pSubi) / Math.log(2));
        }

        StdOut.printf("%.4f\n", h);
    }
}
    

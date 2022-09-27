public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        double h = 0.0;
        int[] freq = new int[m + 1];
        int count = 0;


        while (!StdIn.isEmpty()) {

            int p = StdIn.readInt();

            freq[p]++;
            count++;

            h += (p * Math.log(p) / Math.log(2));
        }
    }
}

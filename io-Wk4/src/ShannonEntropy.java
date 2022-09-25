public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] input = new int[args.length - 1];
        int[] counts = new int[m];
        double sH = 0.0;

        for (int i = 0; i < input.length; i++) {

            input[i] = Integer.parseInt(args[i + 1]);
        }

        for (int i = 0; i < input.length; i++) {

            counts[input[i]]++;
        }

        for (int i = 0; i < counts.length; i++) {

            int pI = counts[i] / input.length;
            double log2pI = Math.log(pI) / Math.log(2);

            double x = -pI * log2pI;

            sH += x;
        }

        StdOut.println(sH);
    }
}

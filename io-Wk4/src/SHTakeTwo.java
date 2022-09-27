public class SHTakeTwo {
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

            double pSubi = freq[i] / (double) count;
            h += -1 * (pSubi * Math.log(pSubi) / Math.log(2));
        }

        StdOut.printf("%.4f\n", h);

//        int m = Integer.parseInt(args[0]);
//
//        double h = 0.0;
//        int[] freq = new int[m + 1];
//        int count = 0;
//
//
//        while (!StdIn.isEmpty()) {
//
//            int p = StdIn.readInt();
////            String line = StdIn.readLine();
////            int[] split = new int[line.split(" ").length];
////            for (int i = 0; i < split.length; i++) {
////                split[i] = Integer.parseInt(line.split(" ")[i]);
////            }
//
//            for (int i = 0; i < split.length; i++) {
//                freq[split[i]]++;
//            }
////            freq[p]++;
//            count++;
//
////            h += (p * Math.log(p) / Math.log(2));
//        }
//
//        for (int i = 1; i < freq.length; i++) {
//
//            double pSubi = freq[i] / (double) count;
//            h += -1 * (pSubi * Math.log(pSubi) / Math.log(2));
//        }
//
//        StdOut.printf("%.4f\n", h);

//        int m = Integer.parseInt(args[0]);
//        int[] input = new int[args.length - 1];
//        int[] counts = new int[m];
//        double sH = 0.0;
//
//        for (int i = 0; i < input.length; i++) {
//
//            input[i] = Integer.parseInt(args[i + 1]);
//        }
//
//        for (int i = 0; i < input.length; i++) {
//
//            counts[input[i]]++;
//        }
//
//        for (int i = 0; i < counts.length; i++) {
//
//            int pI = counts[i] / input.length;
//            double log2pI = Math.log(pI) / Math.log(2);
//
//            double x = -pI * log2pI;
//
//            sH += x;
//        }
//
//        StdOut.println(sH);
    }
}

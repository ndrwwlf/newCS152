public class ThueMorse {
    public static void main(String[] args) {

        int matrixDim = Integer.parseInt(args[0]);
        int n = (int) Math.pow((double) matrixDim, (double) 2);
        boolean[] tMArr = new boolean[]{false};
        int masterDim = matrixDim;

        if (matrixDim == 3) masterDim = 4;
        if (matrixDim > 4 && matrixDim < 8) masterDim = 8;
        if (matrixDim > 8 && matrixDim < 16) masterDim = 16;
        if (matrixDim > 16 && matrixDim < 32) masterDim = 32;
        if (matrixDim > 32 && matrixDim < 64) masterDim = 64;
        if (matrixDim > 64 && matrixDim < 128) masterDim = 128;
        if (matrixDim > 128 && matrixDim < 256) masterDim = 256;

        int matrixDimLog2 = (int) (Math.log((masterDim * masterDim)) / Math.log(2));

        for (int i = 0; i < (matrixDimLog2); i++) {

            boolean[] copy = new boolean[2 * tMArr.length];

            for (int j = 0; j < tMArr.length; j++) {
                copy[j] = tMArr[j];
            }
            for (int k = tMArr.length; k < 2 * tMArr.length; k++) {
                copy[k] = !tMArr[k - tMArr.length];
            }

            tMArr = copy;
        }

        for (int i = 0; i < masterDim; i++) {

            for (int j = i * masterDim; j < (i + 1) * masterDim; j++) {

                if (i < matrixDim && j < masterDim * (i) + matrixDim) {
                    if (!tMArr[j]) {
                        StdOut.print("+  ");
                    } else {
                        StdOut.print("-  ");
                    }
                }
            }
            StdOut.println();
        }

//        int matrixDim = Integer.parseInt(args[0]);
//        int n = (int) Math.pow((double) matrixDim, (double) 2);
//        boolean[] tMArr = new boolean[]{false};
//
//        for (int i = 0; i < ((int) (Math.log(n) / Math.log(2))); i++) {
//
//            boolean[] copy = new boolean[2 * tMArr.length];
//
//            for (int j = 0; j < tMArr.length; j++) {
//                copy[j] = tMArr[j];
//            }
//            for (int k = tMArr.length; k < 2 * tMArr.length; k++) {
//                copy[k] = !tMArr[k - tMArr.length];
//            }
//
//            tMArr = copy;
//        }
//
////        int remainder = n - (int) Math.pow(2.0, (double) log2(n));
//        int remainder = n - (int) Math.pow(2.0, (double) ((int) (Math.log(n) / Math.log(2))));
//        if (remainder > 0) {
//
////            boolean[] copy = new boolean[tMArr.length + remainder];
//            boolean[] copy = Arrays.copyOf(tMArr, tMArr.length + remainder);
//
//            for (int i = 0; i < remainder; i++) {
//                copy[tMArr.length + i] = !tMArr[i];
//            }
//
//            tMArr = copy;
////            boolean[] extras = new boolean[n - remainder];
////            boolean[] copy = new boolean[tMArr.length + extras.length];
////
////            for (int i = 0; i < extras.length; i++) {
////                copy[tMArr.length + (extras.length - i)] = !tMArr[i];
////            }
////            tMArr = copy;
//        }
//
//        for (int i = 0; i < matrixDim; i++) {
//            for (int j = i * matrixDim; j < (i + 1) * matrixDim; j++) {
//                if (!tMArr[j]) {
//                    StdOut.print("+  ");
//                } else {
//                    StdOut.print("-  ");
//                }
//            }
//            StdOut.println();
//        }
//
////        System.out.println(Arrays.toString(tMArr));
////        for (int i = 0; i < n; i++)
//
////        for (int i = 0; i < mDim; i++) {
////
////            for (int j = 0; j < mDim; j++) {
////
////                boolean[] copy = new boolean[]
////            }
////        }
//
////        String line = "+";
////
////        for (int i = 0; i < n; i++) {
////
////            for (int j = 0; j < n; j++) {
////                if ((j & i) == 1) {
////                    StdOut.print("+  ");
////                } else {
////                    StdOut.print("-  ");
////                }
////            }
////
////            StdOut.println();
////        }
//    }
//
//    //(int) (Math.log(n) / Math.log(2))
////    private static int log2(int x) {
////        return (int) (Math.log(x) / Math.log(2));
////    }
    }
}

//public class ThueMorse {
//    public static void main(String[] args) {
//
//        int matrixDim = Integer.parseInt(args[0]);
////        int n = (int) Math.pow((double) matrixDim, (double) 2);
//        boolean[] tMArr = new boolean[]{false};
//        int nextP2;
//
//        /*// calculate the position of the last set bit of `n`
//        int lg = (int) (Math.log(matrixDim - 1) / Math.log(2));
//
//        // next power of two will have a bit set at position `lg+1`.
//        nextP2 = 1 << lg + 1;*/
//
//        /*boolean good = false;
//
//        int width = matrixDim;
//        double log = Math.log(width) / Math.log(2);
//        long roundLog = Math.round(log);
//        int powerOfTwo = (int) (Math.pow(2, roundLog));
//
//        while (!good) {
////            int width = matrixDim;
////            double log = Math.log(width) / Math.log(2);
////            long roundLog = Math.round(log);
////            int powerOfTwo = (int) (Math.pow(2, roundLog));
//
//            if (powerOfTwo >= width) {
//                good = true;
//            } else {
//                width++;
//                log = Math.log(width) / Math.log(2);
//                roundLog = Math.round(log);
//                powerOfTwo = (int) (Math.pow(2, roundLog));
//            }
//        }*/
//
////        long a = Long.highestOneBit(matrixDim);
////        int powerOfTwo = (int) (matrixDim > a ? a << 1 : a);
////
//        int powerOfTwo = matrixDim;
//
//        if (matrixDim != 2) {
//            double log = Math.ceil(Math.log(matrixDim) / Math.log(2));
//            powerOfTwo = (int) Math.pow(log, 2);
//        }
//
////        int logNextP2 = ((int) (Math.log(nextP2) / Math.log(2)));
//        for (int i = 0; i < powerOfTwo; i++) {
//
//            boolean[] copy = new boolean[2 * tMArr.length];
//
//            for (int j = 0; j < tMArr.length; j++) {
//                copy[j] = tMArr[j];
//            }
//            for (int k = tMArr.length; k < 2 * tMArr.length; k++) {
//                copy[k] = !tMArr[k - tMArr.length];
//            }
//
//            tMArr = copy;
//        }
//
////        for (int i = 0; i < matrixDim; i++) {
////            for (int j = i * matrixDim; j < (i + 1) * matrixDim; j++) {
////                if (!tMArr[j]) {
////                    StdOut.print("+  ");
////                } else {
////                    StdOut.print("-  ");
////                }
////            }
////            StdOut.println();
////        }
//
//        for (int i = 0; i < matrixDim; i++) {
//            for (int j = i * powerOfTwo; j < (i * powerOfTwo) + matrixDim; j++) {
//                if (!tMArr[j]) {
//                    StdOut.print("+  ");
//                } else {
//                    StdOut.print("-  ");
//                }
//            }
//            StdOut.println();
//        }
//
//    }
//}

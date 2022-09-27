public class ThueMorse {
    public static void main(String[] args) {

        int matrixDim = Integer.parseInt(args[0]);
        boolean[] tMArr = {false};
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
    }
}

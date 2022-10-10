import java.util.Arrays;

public class AudioCollage {
    public static void main(String[] args) {

    }

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {

        double[] b = Arrays.copyOf(a, a.length);

        for (int i = 0; i < b.length; i++) {

            b[i] += b[i] * (alpha - 1);
        }

        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {

        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {

            b[i] = a[a.length - i - 1];
        }

        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {

        double[] merged = new double[a.length + b.length];

        System.arraycopy(a, 0, merged, 0, a.length);

        if (merged.length - a.length >= 0) {
            System.arraycopy(b, a.length - a.length, merged, a.length, merged.length - a.length);
        }

        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        double[] sums;

        boolean aSmaller = true;
        int lowerLen = a.length;
        sums = new double[b.length];

        if (b.length < a.length) {

            lowerLen = b.length;
            aSmaller = false;
            sums = new double[a.length];
        }

        for (int i = 0; i < lowerLen; i++) {

            sums[i] = a[i] + b[i];
        }

        if (aSmaller) {

            for (int i = a.length; i < sums.length; i++) {

                sums[i] += b[i];
            }
        } else {

            for (int i = b.length; i < sums.length; i++) {

                sums[i] += a[i];
            }
        }

        return sums;

//
//        double[] newA = new double[a.length];
//        double[] newB = new double[b.length];
//        double[] sums;
//
//        if (a.length < b.length) {
//
//            int diff = b.length - a.length;
//
//            newA = new double[diff + a.length];
//
//            System.arraycopy(a, 0, newA, 0, a.length);
//
//            for (int i = a.length; i < newA.length; i++) {
//
//                newA[i] = 0;
//            }
//
//            System.arraycopy(b, 0, newB, 0, b.length);
//
//        } else if (b.length < a.length) {
//
//            int diff = a.length - b.length;
//
//            newB = new double[diff + b.length];
//
//            System.arraycopy(b, 0, newB, 0, b.length);
//
//            for (int i = b.length; i < newB.length; i++) {
//
//                newB[i] = 0;
//            }
//
//            System.arraycopy(a, 0, newA, 0, a.length);
//        }
//
//        sums = new double[newA.length];
//
//        for (int i = 0; i < newA.length; i++) {
//
//            sums[i] = newA[i] + newB[i];
//        }
//
//        return sums;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {

        double[] speed = new double[a.length / 2];
        for (int i = 0; i < speed.length; i++)
            speed[i] = a[2 * i];

        return speed;

//        alpha = StdAudio.SAMPLE_RATE / alpha;
//
//        double[] newSpeedAr = new double[a.length];
//
//        for (int i = 0; i < newSpeedAr.length; i++) {
//
//            newSpeedAr[i] = a[i] * alpha;
//        }
//
//        return newSpeedAr;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
}

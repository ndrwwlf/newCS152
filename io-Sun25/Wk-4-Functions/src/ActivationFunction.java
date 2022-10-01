public class ActivationFunction {
    public static void main(String[] args) {

        double x = Double.parseDouble(args[0]);
        
        StdOut.println(heaviside(x));
        StdOut.println(sigmoid(x));
        StdOut.println(tanh(x));
        StdOut.println(softsign(x));
        StdOut.println(sqnl(x));
    }

    public static double heaviside(double x) {

        if (Double.isNaN(x)) {

            return Double.NaN;
        }

        if (x < 0) {

            return 0;
        } else if (x > 0) {

            return 1;
        } else {

            return 0.5;
        }
    }

    public static double sigmoid(double x) {

        if (Double.isNaN(x)) {

            return Double.NaN;
        }

        return (1 / (1 + Math.exp(-x)));
    }

    public static double tanh(double x) {

        if (Double.isNaN(x)) {

            return Double.NaN;
        }

        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));

    }

    public static double softsign(double x) {

        if (Double.isNaN(x)) {

            return Double.NaN;
        }

        return x / (1 + Math.abs(x));
    }

    public static double sqnl(double x) {

        if (Double.isNaN(x)) {

            return Double.NaN;
        } else if (x <= -2) {

            return -1;
        } else if (x > -2 && x < 0) {

            return (x + (x * x / 4));
        } else if (x >= 0 && x < 2) {

            return (x - x * x / 4);
        } else /*if (x >= 2)*/ {

            return 1;
        }
    }

//    public static boolean isNaN(double x) {
//
//        return Double.isNaN(x);
//    }
}

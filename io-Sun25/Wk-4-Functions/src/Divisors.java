public class Divisors {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println(gcd(a, b));
        StdOut.println(lcm(a, b));
        StdOut.println(areRelativelyPrime(a, b));
        StdOut.println(totient(a));
        StdOut.println(totient(b));
    }

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

//        if (b > a) {
//
//            int c = a;
//            a = b;
//            b = c;
//        }

        while (b != 0) {

            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {

        int gCDAB = gcd(a, b);

        return Math.abs(a) * Math.abs(b) / gCDAB;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {

        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {

        int count = 0;

        for (int i = 1; i < n; i++) {

            if (areRelativelyPrime(i, n)) {

                count++;
            }
        }

        return count;
    }


    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.

}

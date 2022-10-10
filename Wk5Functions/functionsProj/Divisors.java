public class Divisors {
    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println(String.format("gcd(%s, %s) = %s", a, b, gcd(a, b)));
        StdOut.println(String.format("lcm(%s, %s) = %s", a, b, lcm(a, b)));
        StdOut.println(String.format("areRelativelyPrime(%s, %s) = %s", a, b, areRelativelyPrime(a, b)));
        StdOut.println(String.format("totient(%s) = %s", a, totient(a)));
        StdOut.println(String.format("totient(%s) = %s", b, totient(b)));
    }

    public static int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {

            int c = a % b;
            a = b;
            b = c;
        }

        return a;
    }

    public static int lcm(int a, int b) {

        if (a == 0 && b == 0) {
            return 0;
        }

        int gCDAB = gcd(a, b);

        return Math.abs(a) / gCDAB * Math.abs(b);
    }

    public static boolean areRelativelyPrime(int a, int b) {

        return gcd(a, b) == 1;
    }

    public static int totient(int n) {

        if (n == 1) {
            return 1;
        }

        int count = 0;

        for (int i = 1; i < n; i++) {

            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }

        return count;
    }
}

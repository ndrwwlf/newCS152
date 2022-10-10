public class TrinomialBrute {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }

    public static long trinomial(int n, int k) {

        if (n == 0 && k == 0) return 1;
        if (k < -1 * n || k > n) return 0;

        return trinomial(n - 1, k - 1) + trinomial(n - 1, k) + trinomial(n - 1, k + 1);
    }

}

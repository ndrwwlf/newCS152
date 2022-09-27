public class DiscreteDistribution {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] a = new int[args.length - 1];
        int[] s = new int[a.length + 1];
        int r = 0;

        for (int i = 1; i <= a.length; i++) {

            a[i - 1] = Integer.parseInt(args[i]);
        }

        s[0] = 0;

        for (int i = 1; i < s.length; i++) {

            s[i] = s[i - 1] + a[i - 1];
        }


        for (int i = 0; i < m; i++) {

            r = (int) (Math.random() * (s[s.length - 1]));

            for (int j = 1; j <= s.length; j++) {

                if (s[j - 1] <= r && r < s[j]) {
                    
                    System.out.print(j + " ");
                }
            }
        }
    }
}

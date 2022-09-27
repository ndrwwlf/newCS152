public class Birthday {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] counts = new int[n + 1];

        for (int i = 0; i < trials; i++) {

            boolean[] bdays = new boolean[n];

            for (int j = 0; j < n + 1; j++) {

                int bday = (int) (Math.random() * n);

                if (bdays[bday]) {

                    counts[j]++;
                    break;
                } else {

                    bdays[bday] = true;
                }
            }
        }

        for (int i = 0; i < counts.length; i++) {

            int total = 0;

            for (int j = 0; j <= i; j++) {

                total += counts[j];
            }

            double average = total / (double) trials;

            StdOut.printf("%-8d", (i + 1));
            StdOut.printf("%-8d", counts[i]);
            StdOut.printf("%-5s", Double.toString(average));
            StdOut.println();

            if (average >= 0.5) {

                break;
            }
        }
    }
}

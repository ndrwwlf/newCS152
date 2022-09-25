public class RandomWalkers {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int manDis = 0;
        int x = 0;
        int y = 0;
        int stepCount = 0;
        int trials = Integer.parseInt(args[1]);

        int stepsAllTrials = 0;
        double avg = 0;

        for (int i = 0; i < trials; i++) {
            while (manDis != r) {

                int step = (int) (4 * Math.random());

                if (step == 0) {
                    x++;
                } else if (step == 1) {
                    x--;
                } else if (step == 2) {
                    y++;
                } else if (step == 3) {
                    y--;
                }

                stepCount++;
                manDis = Math.abs(x) + Math.abs(y);
            }
            stepsAllTrials += stepCount;
            stepCount = 0;
            manDis = 0;
            x = 0;
            y = 0;
//            avg += Math. stepCount / trials);
        }

        avg = ((double) stepsAllTrials) / (trials);
        System.out.println("average number of steps = " + avg);
    }
}

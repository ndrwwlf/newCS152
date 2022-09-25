public class RandomWalker {
    public static void main(String[] args) {

        int r = Integer.parseInt(args[0]);
        int manDis = 0;
        int x = 0;
        int y = 0;
        int stepCount = 0;

        System.out.println("(0, 0)");

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
            System.out.println("(" + x + ", " + y + ")");
            manDis = Math.abs(x) + Math.abs(y);
        }

        System.out.println("steps = " + stepCount);

    }
}

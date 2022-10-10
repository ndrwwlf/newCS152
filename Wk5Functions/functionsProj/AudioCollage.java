import java.util.Arrays;

public class AudioCollage {
    public static void main(String[] args) {

//        String wavPath = "../functions/";
        String wavPath = "";

        double[] beatbox = StdAudio.read(String.format("%sbeatbox.wav", wavPath));
        StdAudio.play(beatbox);
        double[] buzzer = StdAudio.read(String.format("%sbuzzer.wav", wavPath));
        StdAudio.play(buzzer);
        double[] chimes = StdAudio.read(String.format("%schimes.wav", wavPath));
        StdAudio.play(chimes);
        double[] cow = StdAudio.read(String.format("%scow.wav", wavPath));
        StdAudio.play(cow);
        double[] dialup = StdAudio.read(String.format("%sdialup.wav", wavPath));
        StdAudio.play(dialup);

//        String imagePath = "../functions/logo.png";
//        BufferedImage myPicture = null;
//
//        try {
//            myPicture = ImageIO.read(new File(imagePath));
//        } catch (IOException e) {
//            String workingDir = System.getProperty("user.dir");
//            System.out.println("Current working directory : " + workingDir);
//            e.printStackTrace();
//        }
//
//        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//
//        JPanel jPanel = new JPanel();
//        jPanel.add(picLabel);
//
//        JFrame f = new JFrame();
//        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
//        f.add(jPanel);
//        f.setVisible(true);
    }

    public static double[] amplify(double[] a, double alpha) {

        double[] b = Arrays.copyOf(a, a.length);

        for (int i = 0; i < b.length; i++) {

            b[i] += b[i] * (alpha - 1);
        }

        return b;
    }

    public static double[] reverse(double[] a) {

        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {

            b[i] = a[a.length - i - 1];
        }

        return b;
    }

    public static double[] merge(double[] a, double[] b) {

        double[] merged = new double[a.length + b.length];

        System.arraycopy(a, 0, merged, 0, a.length);

        if (merged.length - a.length >= 0) {
            System.arraycopy(b, 0, merged, a.length, merged.length - a.length);
        }

        return merged;
    }

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
    }


    // Found this on github. I didn't know what they meant by change speed at first
    // but now I see it means resize the 'a' sound array by picking every alpha-th index
    public static double[] changeSpeed(double[] a, double alpha) {

        double[] newSound = new double[(int) (a.length / alpha)];
        for (int i = 0; i < (int) (a.length / alpha); i++) {
            newSound[i] = a[(int) (i * alpha)];
        }
        return newSound;
    }
}

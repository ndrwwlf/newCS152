public class BandMatrix {
    public static void main(String[] args) {

        int mDim = Integer.parseInt(args[0]);
        int distance = Integer.parseInt(args[1]);
//        StringBuilder rowStr = new StringBuilder("");
        String rowStr = "";
        for (int j = 1; j <= mDim; j++) {
            for (int i = 1; i <= mDim; i++) {
                if (Math.abs(j - i) <= distance) {
//                    rowStr = rowStr + ("*  ");
                    System.out.print("*  ");
                } else {
//                    rowStr = rowStr + ("0  ");
                    System.out.print("0  ");
                }
            }
            System.out.println();
            rowStr = "";
        }
    }
}

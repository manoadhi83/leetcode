import java.util.Arrays;

public class LC1891_Premium {

    public static void main(String args[]) {
        //int[] ribbons = {7,5,9};
        //int k =4;

        //int[] ribbons = {9,7,5};
        //int k =3;
        int[] ribbons = {7,5,9};
        int k =22;


        System.out.print("Max ribbon pieces : " + getMaxRibbons(ribbons, k));
    }

    public static int getMaxRibbons(int[] ribbons, int k) {
        int start =1;
        int end = Arrays.stream(ribbons).max().getAsInt();

        int ans = 0;
        while (start<=end) {
            int mid = start + (end-start)/2;
            int pieces = getPiecesForMid(ribbons, mid);
            if(pieces < k) {
                end = mid-1;
            } else {
                ans = mid;
                start =mid+1;
            }
        }
        return ans;
    }

    public static int getPiecesForMid(int[] ribbons, int mid) {
        int pieceCount = 0;
        for(int ribbon: ribbons) {
            pieceCount+= (ribbon/mid);
        }
        return pieceCount;
    }
}

import java.util.Arrays;

public class LC2064 {

    public static void main(String args[]) {
        int[] quantities = {11,6};
        int n=6;
        System.out.print("Min Max product: " + getMinMaxProduct(quantities, n));
    }

    static int getMinMaxProduct(int[] quantities, int n) {
        int start = 1;
        int end = Arrays.stream(quantities).max().getAsInt();
        int ans = -1;
        while(start<=end) {
            int mid = start + (end-start)/2;
            if(canShared(mid, quantities, n)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }

        }
        return ans;
    }

    static boolean canShared(int minQuantity, int[] quantities, int n) {
        int totalStores = 0;
        for(int quantity : quantities) {
            int store = (int) Math.ceil((double) quantity/minQuantity);
            totalStores+=store;
        }
        if(totalStores<=n) {
            return true;
        }
        return false;
    }

}

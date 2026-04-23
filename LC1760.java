import java.util.Arrays;
import java.util.Map;

public class LC1760 {

    public static void main(String args[]) {
        int[] nums = {7,17};
        int maxOperations=2;

        System.out.print("Max Balls : " + getMaxBalls(nums, maxOperations));
    }

    public static int getMaxBalls(int[] nums, int maxOperations) {

        int start =1;
        int end = Arrays.stream(nums).max().getAsInt();
        int ans = -1;
        while(start<=end) {

            int mid = start + (end-start)/2;
            if(isPossible(mid, nums, maxOperations)) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    static boolean isPossible(int balls, int[] nums, int maxOperations) {
        boolean isPossible=false;
        int totalOperations=0;
        for(int num: nums) {
            int operation = (int)Math.ceil((double) num/balls) -1;
            totalOperations+=operation;
        }

        if(totalOperations<=maxOperations) {
            isPossible=true;
        }

        return isPossible;
    }

}

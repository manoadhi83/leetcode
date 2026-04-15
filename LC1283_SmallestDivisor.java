import java.util.Arrays;

public class LC1283_SmallestDivisor {

    public static void main(String args[]) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.print("The smallest possible divisor : " + getSmallestDivisor(nums,threshold));
    }

    public static int getSmallestDivisor(int[] nums, int threshold) {
        int start =1;
        int end = Arrays.stream(nums).max().getAsInt();

        while (start<end) {
            int mid = start + (end-start)/2;
            int calThreshold = getThresholdForDivisor(nums, mid);
            if(calThreshold<=threshold) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static int getThresholdForDivisor(int[] nums, int divisor) {
        int sum = 0;
        for(int num: nums) {
            sum+=(int)(Math.ceil((double) num/divisor));
        }
        return sum;
    }
}

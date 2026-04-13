import java.util.Arrays;

public class LC410_SplitArrays {

    public static void main(String args[]) {
        int[] arr = {7,2,5,10,8};
        int k =2;
        System.out.print("The minimum Sum : " + getMinSumForArr(arr, k));
    }

    public static int getMinSumForArr(int[] arr, int k) {
        int start = Arrays.stream(arr).min().getAsInt();
        int end = Arrays.stream(arr).sum();

        while (start<end) {
            int mid = start + (end-start)/2;
            int calArrays = getSubArrsForMidSum(arr, mid);
            if(calArrays > k) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static int getSubArrsForMidSum(int[] arr, int midSum) {
        int sum=0;
        int calArrays = 1;

        for (int number: arr) {
            if (sum+number > midSum) {
                sum=0;
                calArrays++;
            }
            sum+=number;
        }
        return calArrays;
    }

}

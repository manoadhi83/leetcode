import java.util.Arrays;

public class LC1011_CapacityShip {

    public static void main(String args[]) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println("The Minimum weight is : " + getMinWeight(weights, days));
    }

    static int getMinWeight(int[] weights, int days) {
        int start = 1;
        int end = Arrays.stream(weights).sum();

        while (start<end) {
            int mid = start + (end-start)/2;
            int calDays = getDaysForMid(weights, mid, days);
            if(calDays > days) {
                start = mid+1;
            } else {
                end = mid;
            }

        }
        return start;
    }

    static int getDaysForMid(int[] weights, int minWt, int days) {
        int sum =0;
        int calDays =1;
        for (int weight : weights) {
            if (sum + weight > minWt) {
                sum = 0;
                calDays++;
            }
            sum += weight;
        }
        return calDays;
    }


}

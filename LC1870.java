import java.util.Arrays;

public class LC1870 {

    public static void main(String args[]) {
        int[] dist = {1,1,100000};
        double hour = 2.01;
        System.out.print("Output: " + new LC1870().minSpeedOnTime(dist, hour));
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int start =1;
        double remaining = hour - (dist.length - 1);
        int maxDist = Arrays.stream(dist).max().getAsInt();
        int end = 10_000_000;
        int ans = -1;

        while(start<=end) {
            int mid = start+(end-start)/2;
            double calHour = getCalHourForMid(mid, dist);
            if(calHour<=hour) {
                ans = mid;
                end = mid-1;
            } else {
                start=mid+1;
            }
        }
        return ans;
    }

    double getCalHourForMid(int midSpeed, int[] dist) {
        double totalHour=0.0;
        for (int i = 0; i < dist.length; i++) {
            double time = (double) dist[i] / midSpeed;

            if (i != dist.length - 1) {
                totalHour += Math.ceil(time);
            } else {
                totalHour += time;
            }
        }
        return totalHour;
    }
}

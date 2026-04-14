import java.util.Arrays;

public class AggressiveCows {

    public static void main(String args[]) {

        int[] positions = {0,3,4,7,10,9};
        int cows = 4;

        System.out.print("The maximum minimum distance between the cows : "+ getMaxMinDistanceBetweenCows(positions, cows));
    }


    public static int getMaxMinDistanceBetweenCows(int[] positions, int cows) {
        Arrays.sort(positions);
        int start = 1;
        int end = Arrays.stream(positions).max().getAsInt();
        int ans = 1;
        while (start<end) {
            int mid = start + (end-start)/2;
            if(isPlaced(positions, mid, cows)) {
                ans = mid;
                start = mid+1;
                continue;
            } else {
                end = mid -1;
            }
        }
        return ans;
    }

    public static boolean isPlaced(int[] positions, int distance, int cows) {
        int lastPosition = positions[0];
        int cowsCount = 1;
        for(int i=1; i<positions.length; i++) {
            if (positions[i] - lastPosition >= distance) {
                lastPosition = positions[i];
                cowsCount++;
            }
        }
        return cowsCount == cows;
    }
}

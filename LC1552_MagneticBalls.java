import java.util.Arrays;

public class LC1552_MagneticBalls {

    public static void main(String args[]) {
        int[] positions = {1,2,3,4,7};
        int m=3;

        System.out.println("max distance between the balls: "+ getMinDistanceBetweenBalls(positions, m));
    }

    public static int getMinDistanceBetweenBalls(int[] positions, int balls) {

        int start = Arrays.stream(positions).min().getAsInt();
        int end = Arrays.stream(positions).max().getAsInt()-1;
        while (start<end) {
            int mid = start + (end-start)/2;
            int calBalls = getBallsForMinDistance(positions, mid);
            if(calBalls < balls) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    public static int getBallsForMinDistance(int[] positions, int minDistance) {
        int balls =1;
        int lastBall = positions[0];
        for(int i=1;i<positions.length;i++) {
            if(positions[i] - lastBall >= minDistance) {
                balls++;
                lastBall = positions[i];
            }
        }
        return balls;
    }
}

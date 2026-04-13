import java.util.Arrays;

public class LC875_KokoEatingBananas {

    public static void main(String args[]) {
        int[] piles = {3,6,7,11};
        int hours =8;
        System.out.print("Miinimum eating speed : "+ getMinEatingSpeed(piles, hours));
    }

    public static int getMinEatingSpeed(int[] piles, int hours) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();

        while (start<end) {
            int mid = start + (end-start)/2;
            int calHrs = getHoursByMid(piles, mid);
            if(calHrs<= hours) {
                end = mid;
            } else {
                start = mid +1;
            }
        }

        return start;
    }

    public static int getHoursByMid(int[] piles, int mid) {

        int sum =0;
        for(int pile: piles) {
            int speed = (int) Math.ceil((double) pile / mid);
            sum +=speed;
        }
        return sum;
    }
}

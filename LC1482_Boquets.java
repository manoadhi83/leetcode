import java.util.Arrays;

public class LC1482_Boquets {

    public static void main(String args[]) {
        int[] bloomDays = {1,10,3,10,2};
        int m = 3;
        int k =1;


//        int[] bloomDays = {1,10,3,10,2};
//        int m = 3;
//        int k =2;

        System.out.print("Minimum days : "+ minBoquests(bloomDays, m,k));
    }

    public static int minBoquests(int[] bloomDays, int m, int k) {
        if (m*k > bloomDays.length) return -1;

        int start = Arrays.stream(bloomDays).min().getAsInt();
        int end = Arrays.stream(bloomDays).max().getAsInt();

        while (start<=end) {
            int mid = start + (end-start)/2;
            int calBoquets = getBoquets(bloomDays, mid, k);
            if (calBoquets < m) {
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }
        return start;
    }

    public static int getBoquets(int[] bloomDays, int min, int k) {
        int flowerCount=0;
        int boquetCount = 0;
        for(int i =0; i<bloomDays.length;i++) {
            if (min>=bloomDays[i]) {
                flowerCount++;
                if(flowerCount==k) {
                    boquetCount++;
                    flowerCount=0;
                }
            } else {
                flowerCount=0;
            }
        }
        return  boquetCount;
    }
}

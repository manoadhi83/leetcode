import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    public static void main(String args[]) {

        int[][] intervals = new int[][] {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.print("Intervals:  "+ Arrays.deepToString(getNonOverlappingIntervals(intervals)));
    }

    static int[][] getNonOverlappingIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));

        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                result.add(interval);
                newInterval = interval;
            }
        }
        return result.toArray(int[][]::new);
    }
}

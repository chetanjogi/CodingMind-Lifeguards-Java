import java.util.*;
import java.util.random.RandomGenerator;

public class Lifeguards {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int n;
        int[] start;
        int[] end;


//        n = sc.nextInt();
//        start = new int[n];
//        end = new int[n];
//        int max_timeline = 0;
//        for (int i = 0; i < n; i++) {
//            start[i] = sc.nextInt();
//            end[i] = sc.nextInt();
//            max_timeline = Math.max(max_timeline, Math.max(start[i],end[i]));
//        }


        Random rand = new Random();
        n = 100;
        int max_timeline = 1000;
        start = new int[n];
        end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = rand.nextInt(0,1000);
            end[i] = rand.nextInt(start[i] + 1,1001);
        }

        int maxCoveredTime = 0;
        long startTime = System.currentTimeMillis();


        // Try removing each lifeguard
        for (int removed = 0; removed < n; removed++) {

            boolean[] timeCovered = new boolean[max_timeline + 1];

            // Mark time covered by remaining lifeguards
            for (int i = 0; i < n; i++) {
                if (i == removed) continue;

                for (int t = start[i]; t < end[i]; t++) {
                    timeCovered[t] = true;
                }
            }

            // Count covered time
            int total = 0;
            for (int t = 0; t < max_timeline +1; t++) {
                if (timeCovered[t]) {
                    total++;
                }
            }

            maxCoveredTime = Math.max(maxCoveredTime, total);
        }

        System.out.println(maxCoveredTime);

        long endTime  = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }
}

import java.util.*;

public class LifeguardsOptimized {

    static class Guard {
        int start, end;
        Guard(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        Guard[] g = new Guard[n];
//        for (int i = 0; i < n; i++) {
//            g[i] = new Guard(sc.nextInt(), sc.nextInt());
//        }

        int n = 100;
        Guard[] g = new Guard[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int start = rand.nextInt(0, 1000);
            int end = rand.nextInt(start + 1, 1001);
            g[i] = new Guard(start, end);
        }

        long startTime = System.currentTimeMillis();
        // Sort by start time
        Arrays.sort(g, Comparator.comparingInt(a -> a.start));

        int totalCovered = 0;
        int minAlone = Integer.MAX_VALUE;
        int prevEnd = 0;

        for (int i = 0; i < n; i++) {

            // total coverage
            totalCovered += Math.max(0, g[i].end - Math.max(g[i].start, prevEnd));

            // alone time
            int leftOverlap = (i > 0) ? Math.max(g[i].start, g[i - 1].end) : g[i].start;
            int rightOverlap = (i < n - 1) ? Math.min(g[i].end, g[i + 1].start) : g[i].end;

            int alone = Math.max(0, rightOverlap - leftOverlap);


            minAlone = Math.min(minAlone, alone);
            prevEnd = Math.max(prevEnd, g[i].end);

        }

        System.out.println(totalCovered - minAlone);
//
        long endTime  = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }
}
